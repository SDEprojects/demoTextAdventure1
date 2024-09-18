package stage8_refactor_MVC_adding_console;

import java.util.Scanner;

public class TextAdventureConsoleView {
    private TextAdventureController controller;

    public void setController(TextAdventureController controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        controller.startGame();

        while (true) {
            System.out.print("Enter a command (e.g., 'Go north', 'Look', 'quit'): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            controller.handleCommand(input);
        }
    }

    public void display(String message) {
        System.out.println(message);
    }
}