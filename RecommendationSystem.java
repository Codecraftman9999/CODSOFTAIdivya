import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RecommendationSystem {

    // Define a map to store user preferences
    private Map<String, Map<String, Integer>> userPreferences;

    public RecommendationSystem() {
        this.userPreferences = new HashMap<>();
    }

    // Method to add user preferences
    public void addUserPreferences(String user, Map<String, Integer> preferences) {
        userPreferences.put(user, preferences);
    }

    // Method to recommend items to a user based on collaborative filtering
    public Set<String> recommendItems(String user) {
        Set<String> recommendedItems = new HashSet<>();
        Map<String, Integer> currentUserPreferences = userPreferences.get(user);

        for (Map.Entry<String, Map<String, Integer>> entry : userPreferences.entrySet()) {
            if (!entry.getKey().equals(user)) {
                Map<String, Integer> otherUserPreferences = entry.getValue();

                for (Map.Entry<String, Integer> itemEntry : otherUserPreferences.entrySet()) {
                    if (!currentUserPreferences.containsKey(itemEntry.getKey())) {
                        recommendedItems.add(itemEntry.getKey());
                    }
                }
            }
        }

        return recommendedItems;
    }

    public static void main(String[] args) {
        RecommendationSystem system = new RecommendationSystem();

        // Add user preferences
        Map<String, Integer> user1Preferences = new HashMap<>();
        user1Preferences.put("Movie1", 5);
        user1Preferences.put("Movie2", 4);
        system.addUserPreferences("User1", user1Preferences);

        Map<String, Integer> user2Preferences = new HashMap<>();
        user2Preferences.put("Movie2", 5);
        user2Preferences.put("Movie3", 4);
        system.addUserPreferences("User2", user2Preferences);

        Map<String, Integer> user3Preferences = new HashMap<>();
        user3Preferences.put("Movie1", 3);
        user3Preferences.put("Movie3", 5);
        system.addUserPreferences("User3", user3Preferences);

        // Recommend items to User1
        Set<String> recommendations = system.recommendItems("User1");
        System.out.println("Recommended items for User1: " + recommendations);
    }
}