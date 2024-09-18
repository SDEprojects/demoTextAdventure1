package stage7_refactor_MVC;

// This is the CONTROLLER

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAdventureController implements ActionListener {
    private TextAdventureGame model;
    private TextAdventureView view;

    public TextAdventureController(TextAdventureGame model, TextAdventureView view) {
        this.model = model;
        this.view = view;
        view.setController(this);  // Set the controller in the view
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the user input from the view
        String command = view.getInput();

        // Process the command and update the model and view
        String response;
        if (command.startsWith("go ")) {  // Handle "Go [direction]" commands
            String direction = command.substring(3);
            response = model.go(direction);
        } else if (command.equalsIgnoreCase("look")) {  // Handle "Look" command
            response = model.look();
        } else {
            response = "Invalid command. Use 'Go [direction]' or 'Look'.";
        }

        // Update the view with the response and current location
        view.updateOutput("> " + command);  // Show the command
        view.updateOutput(response);  // Show the result of the command
        view.updateOutput(model.getCurrentLocation());  // Show the updated location
    }

    // Start the game
    public void startGame() {
        view.updateOutput("Welcome to the Forest Adventure!");
        view.updateOutput(model.getCurrentLocation());
    }
}
