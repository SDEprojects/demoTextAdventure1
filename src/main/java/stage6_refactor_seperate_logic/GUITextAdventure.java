package stage6_refactor_seperate_logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITextAdventure extends JFrame implements ActionListener {
    private TextAdventureGame game;  // Game logic instance
    private JTextArea outputArea;    // To display game output
    private JTextField inputField;   // To take user input (commands)

    public GUITextAdventure() {
        game = new TextAdventureGame();  // Initialize the game logic

        // Set up the JFrame (window)
        setTitle("Forest Adventure");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Output area (game messages)
        outputArea = new JTextArea();
        outputArea.setEditable(false);  // User can't type here, just displays output
        outputArea.setLineWrap(true);   // Wrap text to next line if too long
        outputArea.setWrapStyleWord(true);  // Wrap by words
        add(new JScrollPane(outputArea), BorderLayout.CENTER);  // Scrollable area

        // Input field (user commands)
        inputField = new JTextField();
        inputField.addActionListener(this);  // Action listener to detect "Enter" key
        add(inputField, BorderLayout.SOUTH);  // Add the text field at the bottom

        // Display the initial location when the game starts
        outputArea.append("Welcome to the Forest Adventure!\n");
        outputArea.append(game.getCurrentLocation() + "\n");
    }

    // Action handler when the user presses "Enter"
    public void actionPerformed(ActionEvent e) {
        String command = inputField.getText().trim();  // Get user input from the text field
        inputField.setText("");  // Clear the input field after taking the input

        // Check if the user wants to quit
        if (command.equalsIgnoreCase("quit")) {
            outputArea.append("Thanks for playing!\n");
            inputField.setEnabled(false);  // Disable input after quitting
            return;
        }

        // Process the input and update the game state
        String response;
        if (command.startsWith("go ")) {  // Handle "Go [direction]" commands
            String direction = command.substring(3);
            response = game.go(direction);
        } else if (command.equalsIgnoreCase("look")) {  // Handle "Look" command
            response = game.look();
        } else {
            response = "Invalid command. Use 'Go [direction]' or 'Look'.";
        }

        // Append the output to the output area (what the player did + the result)
        outputArea.append("> " + command + "\n");  // Show the user command
        outputArea.append(response + "\n");  // Show the result of the command
        outputArea.append(game.getCurrentLocation() + "\n");  // Show the updated location
        outputArea.setCaretPosition(outputArea.getDocument().getLength());  // Auto-scroll to bottom
    }

    // Main method to start the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUITextAdventure adventure = new GUITextAdventure();
            adventure.setVisible(true);  // Make the GUI visible
        });
    }
}
