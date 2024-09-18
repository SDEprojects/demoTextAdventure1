package stage6_refactor_seperate_logic;

public class TextAdventureGame {
    private int playerX = 2;
    private int playerY = 2;

    // Basic descriptions of each location
    private String[][] forest = {
            {"You are at the edge of a dense forest.", "You are surrounded by towering trees.", "You see a distant mountain beyond the forest."},
            {"A narrow path leads deeper into the woods.", "A small stream flows nearby.", "A deer darts across your path."},
            {"You find an abandoned campfire.", "The birds are singing.", "This part of the forest is eerily quiet."}
    };

    // Detailed descriptions of each location for the "Look" command
    private String[][] detailedDescriptions = {
            {"You notice thick undergrowth and hear rustling in the bushes.", "The trees are so tall they block out most of the sunlight.", "The mountain looms large in the distance, shrouded in mist."},
            {"The path twists and turns. You wonder where it leads.", "The stream is crystal clear. You can see fish swimming.", "The deer is gone, but the hoofprints remain in the dirt."},
            {"The campfire has been long abandoned, the ashes cold.", "The birds are chirping loudly, filling the air with sound.", "The quiet here is unnerving, as if something is watching you."}
    };

    // Method for moving the player
    public String go(String direction) {
        String result = "";
        switch (direction.toLowerCase()) {
            case "north":
                if (playerX > 0) {
                    playerX--;
                    result = "You go north.";
                } else {
                    result = "You can't move further north.";
                }
                break;
            case "south":
                if (playerX < forest.length - 1) {
                    playerX++;
                    result = "You go south.";
                } else {
                    result = "You can't move further south.";
                }
                break;
            case "east":
                if (playerY < forest[0].length - 1) {
                    playerY++;
                    result = "You go east.";
                } else {
                    result = "You can't move further east.";
                }
                break;
            case "west":
                if (playerY > 0) {
                    playerY--;
                    result = "You go west.";
                } else {
                    result = "You can't move further west.";
                }
                break;
            default:
                result = "Invalid direction.";
        }
        return result;
    }

    // Method for looking around
    public String look() {
        return "You look around. " + detailedDescriptions[playerX][playerY];
    }

    // Method for getting the current location description
    public String getCurrentLocation() {
        return forest[playerX][playerY];
    }
}
