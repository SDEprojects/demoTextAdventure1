package stage6_refactor_seperate_logic;

import java.util.Scanner;

public class TextAdventure {
    public static void main(String[] args) {
        TextAdventureGame game = new TextAdventureGame();  // Create the game logic object
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the Forest Adventure!");
        System.out.println(game.getCurrentLocation());  // Show the initial location

        while (true) {
            System.out.print("Enter a command (e.g., 'Go north', 'Look', 'quit'): ");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (input.startsWith("go")) {
                String direction = input.substring(3); // Extract the direction after "Go"
                System.out.println(game.go(direction));
            } else if (input.equals("look")) {
                System.out.println(game.look());
            } else {
                System.out.println("Invalid command. Use 'Go [direction]' or 'Look'.");
            }

            System.out.println(game.getCurrentLocation());
        }

        scanner.close();
    }
}
