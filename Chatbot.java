import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            System.out.print("User: ");
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("hello")) {
                System.out.println("Chatbot: Hello! How can I assist you today?");
            } else if (userInput.equalsIgnoreCase("how are you")) {
                System.out.println("Chatbot: I'm doing well, thank you for asking!");
            } else if (userInput.equalsIgnoreCase("what is your name")) {
                System.out.println("Chatbot: My name is Chatbot. Nice to meet you!");
            } else if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chatbot: Goodbye! It was nice chatting with you.");
                break;
            } else {
                System.out.println("Chatbot: I didn't understand that. Please try again!");
                }
        }

        scanner.close();
    }
}

