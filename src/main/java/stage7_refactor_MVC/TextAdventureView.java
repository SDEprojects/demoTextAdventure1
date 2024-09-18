package stage7_refactor_MVC;

// THIS IS THE GUI VIEW

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAdventureView extends JFrame {
    private JTextArea outputArea;
    private JTextField inputField;
    private ActionListener controller;

    public TextAdventureView() {
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
        inputField.addActionListener(e -> {
            if (controller != null) {
                controller.actionPerformed(e);  // Delegate input to the controller
            }
        });
        add(inputField, BorderLayout.SOUTH);  // Add the text field at the bottom
    }

    public void setController(ActionListener controller) {
        this.controller = controller;
    }

    // Update the game display
    public void updateOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());  // Auto-scroll to bottom
    }

    // Get the user input (for the controller)
    public String getInput() {
        String input = inputField.getText().trim();
        inputField.setText("");  // Clear the input field
        return input;
    }

    // Show the game window
    public void start() {
        setVisible(true);
    }
}
