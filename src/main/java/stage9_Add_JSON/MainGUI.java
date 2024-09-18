package stage9_Add_JSON;

public class MainGUI {
    public static void main(String[] args) {
        // Create the model, view, and controller for the GUI version
        TextAdventureGame model = new TextAdventureGame();
        TextAdventureView guiView = new TextAdventureView();
        TextAdventureController controller = new TextAdventureController(model, guiView);

        // Start the game in the GUI
        guiView.start();
    }
}