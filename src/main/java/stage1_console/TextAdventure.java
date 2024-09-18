package stage1_console;

import java.util.Scanner;

public class TextAdventure {
    static int playerX = 2;
    static int playerY = 2;
    static String[][] forest = {
            {"Trees block your path.", "A thick forest surrounds you.", "You see a distant mountain."},
            {"A narrow path leads deeper into the woods.", "A small stream is nearby.", "A deer runs past you."},
            {"You find an abandoned campfire.", "You hear birds singing.", "The forest is quiet here."}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Welcome to the Forest Adventure!");
        printCurrentLocation();

        while (true) {
            System.out.print("Enter a direction (north, south, east, west) or type 'quit' to exit: ");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            movePlayer(input);
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
                System.out.println("Invalid direction. Please enter 'north', 'south', 'east', or 'west'.");
        }
    }

    public static void printCurrentLocation() {
        System.out.println(forest[playerX][playerY]);
    }
}
