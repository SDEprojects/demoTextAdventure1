package stage8_refactor_MVC_adding_console;

public class MainConsole {
    public static void main(String[] args) {
        // Create the model, view, and controller for the console version
        TextAdventureGame model = new TextAdventureGame();
        TextAdventureConsoleView consoleView = new TextAdventureConsoleView();
        TextAdventureController controller = new TextAdventureController(model, consoleView);

        // Start the game in the console
        consoleView.start();
    }
}
