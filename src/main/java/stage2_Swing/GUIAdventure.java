package stage2_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAdventure extends JFrame implements ActionListener {
    static int playerX = 2;
    static int playerY = 2;
    static String[][] forest = {
            {"Trees block your path.", "A thick forest surrounds you.", "You see a distant mountain."},
            {"A narrow path leads deeper into the woods.", "A small stream is nearby.", "A deer runs past you."},
            {"You find an abandoned campfire.", "You hear birds singing.", "The forest is quiet here."}
    };

    JTextArea outputArea;
    JButton northButton, southButton, eastButton, westButton;

    public GUIAdventure() {
        setTitle("Forest Adventure");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text area for game output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Panel for direction buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        northButton = new JButton("North");
        southButton = new JButton("South");
        eastButton = new JButton("East");
        westButton = new JButton("West");

        northButton.addActionListener(this);
        southButton.addActionListener(this);
        eastButton.addActionListener(this);
        westButton.addActionListener(this);

        buttonPanel.add(new JLabel());  // Empty label for padding
        buttonPanel.add(northButton);
        buttonPanel.add(new JLabel());  // Empty label for padding
        buttonPanel.add(westButton);
        buttonPanel.add(new JLabel());  // Empty label for padding
        buttonPanel.add(eastButton);
        buttonPanel.add(new JLabel());  // Empty label for padding
        buttonPanel.add(southButton);
        buttonPanel.add(new JLabel());  // Empty label for padding

        add(buttonPanel, BorderLayout.SOUTH);

        // Print initial location
        printCurrentLocation();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == northButton) {
            movePlayer("north");
        } else if (e.getSource() == southButton) {
            movePlayer("south");
        } else if (e.getSource() == eastButton) {
            movePlayer("east");
        } else if (e.getSource() == westButton) {
            movePlayer("west");
        }
        printCurrentLocation();
    }

    public void movePlayer(String direction) {
        switch (direction) {
            case "north":
                if (playerX > 0) playerX--;
                else outputArea.append("You can't move further north.\n");
                break;
            case "south":
                if (playerX < forest.length - 1) playerX++;
                else outputArea.append("You can't move further south.\n");
                break;
            case "east":
                if (playerY < forest[0].length - 1) playerY++;
                else outputArea.append("You can't move further east.\n");
                break;
            case "west":
                if (playerY > 0) playerY--;
                else outputArea.append("You can't move further west.\n");
                break;
            default:
                outputArea.append("Invalid direction.\n");
        }
    }

    public void printCurrentLocation() {
        outputArea.append(forest[playerX][playerY] + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUIAdventure game = new GUIAdventure();
            game.setVisible(true);
        });
    }
}
