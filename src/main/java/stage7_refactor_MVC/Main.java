package stage7_refactor_MVC;

// THE MAIN CLASS
public class Main {
    public static void main(String[] args) {
        // Initialize the model, view, and controller
        TextAdventureGame model = new TextAdventureGame();
        TextAdventureView view = new TextAdventureView();
        TextAdventureController controller = new TextAdventureController(model, view);

        // Start the game
        controller.startGame();
        view.start();  // Show the view
    }
}
