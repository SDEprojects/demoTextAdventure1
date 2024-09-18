package stage9_Add_JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
public class TextAdventureGame {

/*    private int playerX = 2;
    private int playerY = 2;
    private Map<String, Location> locations; // Now using this for the JSON files*/


    //Changing this to JSON
    // Basic descriptions of each location
/*    private String[][] forest = {
            {"You are at the edge of a dense forest.", "You are surrounded by towering trees.", "You see a distant mountain beyond the forest."},
            {"A narrow path leads deeper into the woods.", "A small stream flows nearby.", "A deer darts across your path."},
            {"You find an abandoned campfire.", "The birds are singing.", "This part of the forest is eerily quiet."}
    };

    // Detailed descriptions of each location for the "Look" command
    private String[][] detailedDescriptions = {
            {"You notice thick undergrowth and hear rustling in the bushes.", "The trees are so tall they block out most of the sunlight.", "The mountain looms large in the distance, shrouded in mist."},
            {"The path twists and turns. You wonder where it leads.", "The stream is crystal clear. You can see fish swimming.", "The deer is gone, but the hoofprints remain in the dirt."},
            {"The campfire has been long abandoned, the ashes cold.", "The birds are chirping loudly, filling the air with sound.", "The quiet here is unnerving, as if something is watching you."}
    };*/
    public TextAdventureGame() {
        loadGameData();
    }
    private void loadGameData() {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("game_data.json");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            if (inputStream == null) {
                throw new IOException("File not found: game_data.json");
            }
            Gson gson = new Gson();
            // Define the type for a Map<String, Location>
            Type locationMapType = new TypeToken<Map<String, Location>>() {}.getType();
            locations = gson.fromJson(reader, locationMapType);  // Parse the JSON into a Map
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            locations = new HashMap<>();  // Fallback in case of failure
        }
    }

    // Method for moving the player
    public String go(String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                if (playerX > 0) playerX--;
                else return "You can't move further north.";
                break;
            case "south":
                playerX++;
                break;
            case "east":
                playerY++;
                break;
            case "west":
                if (playerY > 0) playerY--;
                else return "You can't move further west.";
                break;
            default:
                return "Invalid direction.";
        }
        return "You go " + direction + ".";
    }

    // Method for looking around
/*
    public String look() {
        return "You look around. " + detailedDescriptions[playerX][playerY];
    }
*/
    public String look() {
        String key = playerX + "," + playerY;
        Location location = locations.get(key);
        if (location != null) {
            return location.getDetailedDescription();
        }
        return "There's nothing special here.";
    }


    // Method for getting the current location description
/*    public String getCurrentLocation() {
        return forest[playerX][playerY];
    }*/

    public String getCurrentLocation() {
        String key = playerX + "," + playerY;
        Location location = locations.get(key);
        if (location != null) {
            return location.getDescription();
        }
        return "Unknown location.";
    }
}