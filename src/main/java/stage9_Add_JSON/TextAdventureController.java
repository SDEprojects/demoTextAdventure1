package stage9_Add_JSON;

public class TextAdventureController {
    private TextAdventureGame model;
    private TextAdventureConsoleView consoleView;
    private TextAdventureView guiView;

    // Constructor for console version
    public TextAdventureController(TextAdventureGame model, TextAdventureConsoleView consoleView) {
        this.model = model;
        this.consoleView = consoleView;
        consoleView.setController(this);
    }

    // Constructor for GUI version
    public TextAdventureController(TextAdventureGame model, TextAdventureView guiView) {
        this.model = model;
        this.guiView = guiView;
        guiView.setController(this);
    }

    public void handleCommand(String command) {
        String response;
        if (command.startsWith("go ")) {
            String direction = command.substring(3);
            response = model.go(direction);
        } else if (command.equalsIgnoreCase("look")) {
            response = model.look();
        } else {
            response = "Invalid command. Use 'Go [direction]' or 'Look'.";
        }

        // Display the output depending on the view type
        if (consoleView != null) {
            consoleView.display("> " + command);
            consoleView.display(response);
            consoleView.display(model.getCurrentLocation());
        } else if (guiView != null) {
            guiView.display("> " + command);
            guiView.display(response);
            guiView.display(model.getCurrentLocation());
        }
    }

    public void startGame() {
        if (consoleView != null) {
            consoleView.display("Welcome to the Forest Adventure!");
            consoleView.display(model.getCurrentLocation());
        } else if (guiView != null) {
            guiView.display("Welcome to the Forest Adventure!");
            guiView.display(model.getCurrentLocation());
        }
    }
}