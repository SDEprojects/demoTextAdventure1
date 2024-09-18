package stage10_json_as_Objects;

// THIS IS THE GUI VIEW

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAdventureView extends JFrame {
    private JTextArea outputArea;
    private JTextField inputField;
    private TextAdventureController controller;

    public TextAdventureView() {
        // Set up the JFrame (window)
        setTitle("Forest Adventure");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Output area (game messages)
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Input field (user commands)
        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                inputField.setText("");
                controller.handleCommand(input);
            }
        });
        add(inputField, BorderLayout.SOUTH);
    }

    public void setController(TextAdventureController controller) {
        this.controller = controller;
    }

    public void display(String message) {
        outputArea.append(message + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength()); // Auto-scroll
    }

    public void start() {
        setVisible(true);
        controller.startGame();
    }
}