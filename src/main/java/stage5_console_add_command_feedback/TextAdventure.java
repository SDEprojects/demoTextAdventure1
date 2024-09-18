package stage5_console_add_command_feedback;

// Adding in lastCommand to display the most previous command.

import java.util.Scanner;

public class TextAdventure {
    static int playerX = 2;
    static int playerY = 2;
    static String lastCommand = "";

    // Basic descriptions of each location
    static String[][] forest = {
            {"You are at the edge of a dense forest.", "You are surrounded by towering trees.", "You see a distant mountain beyond the forest."},
            {"A narrow path leads deeper into the woods.", "A small stream flows nearby.", "A deer darts across your path."},
            {"You find an abandoned campfire.", "The birds are singing.", "This part of the forest is eerily quiet."}
    };

    // Detailed descriptions of each location for the "Look" command
    static String[][] detailedDescriptions = {
            {"You notice thick undergrowth and hear rustling in the bushes.", "The trees are so tall they block out most of the sunlight.", "The mountain looms large in the distance, shrouded in mist."},
            {"The path twists and turns. You wonder where it leads.", "The stream is crystal clear. You can see fish swimming.", "The deer is gone, but the hoofprints remain in the dirt."},
            {"The campfire has been long abandoned, the ashes cold.", "The birds are chirping loudly, filling the air with sound.", "The quiet here is unnerving, as if something is watching you."}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Welcome to the Forest Adventure!");
        printCurrentLocation();

        while (true) {
            System.out.print("Enter a command (e.g., 'Go north', 'Look', 'quit'): ");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            } else if (input.startsWith("go")) {
                String direction = input.substring(3); // Extract the direction after "Go"
                movePlayer(direction);
                lastCommand = "You go " + direction + ".";
            } else if (input.equals("look")) {
                printDetailedDescription();
                lastCommand = "You look around.";
            } else {
                lastCommand = "Invalid command.";
                System.out.println(lastCommand + " Use 'Go [direction]' or 'Look'.");
                continue;
            }

            clearScreen(); // Clear the console before showing the next output
            System.out.println(lastCommand); // Show the last executed command
            printCurrentLocation();
        }

        scanner.close();
    }

    public static void movePlayer(String direction) {
        switch (direction) {
            case "north":
                if (playerX > 0) playerX--;
                else System.out.println("You can't move further north.");
                break;
            case "south":
                if (playerX < forest.length - 1) playerX++;
                else System.out.println("You can't move further south.");
                break;
            case "east":
                if (playerY < forest[0].length - 1) playerY++;
                else System.out.println("You can't move further east.");
                break;
            case "west":
                if (playerY > 0) playerY--;
                else System.out.println("You can't move further west.");
                break;
            default:
                lastCommand = "Invalid direction.";
                System.out.println("Invalid direction. Use 'Go north', 'Go south', 'Go east', or 'Go west'.");
        }
    }

    public static void printCurrentLocation() {
        System.out.println(forest[playerX][playerY]);
    }

    public static void printDetailedDescription() {
        System.out.println(detailedDescriptions[playerX][playerY]);
    }

    // This method simulates clearing the screen by printing several new lines
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}