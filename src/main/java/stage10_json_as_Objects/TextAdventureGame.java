package stage10_json_as_Objects;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
public class TextAdventureGame {
    // Previous Code
/*    private int playerX = 2;
    private int playerY = 2;
    private Map<String, Location> locations; // Now using this for the JSON files*/
    private Location currentLocation;  // Current player location
    private Map<String, Location> locations;  // Map to store locations by name

    public TextAdventureGame() {
        loadGameData(); // Load the game data from JSON
        currentLocation = locations.get("Stream");  // Start the game at the Stream
    }

/*    private void loadGameData() {

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
    }*/
    private void loadGameData() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("Location_data.json");

            // Parse JSON into a list of Location objects
            Type locationListType = new TypeToken<Map<String, Location>>() {}.getType();
            locations = gson.fromJson(reader, locationListType);  // Load locations into a map
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            locations = new HashMap<>();  // Fallback in case of failure
        }
    }

    // Method for moving the player
    /*public String go(String direction) {
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
    }*/
    // Method for moving the player
    public String go(String direction) {
        Map<String, String> exits = currentLocation.getExits();  // Get the current location's exits
        if (exits.containsKey(direction)) {
            String nextLocationName = exits.get(direction);  // Get the location name in the direction
            currentLocation = locations.get(nextLocationName);  // Move to the new location
            return "You go " + direction + ".";
        } else {
            return "You can't go that way.";
        }
    }

    // Method for looking around

/*    public String look() {
        String key = playerX + "," + playerY;
        Location location = locations.get(key);
        if (location != null) {
            return location.getDetailedDescription();
        }
        return "There's nothing special here.";
    }*/
    public String look() {
        return currentLocation.getDetailedDescription();
    }


    // Method for getting the current location description
/*    public String getCurrentLocation() {
        String key = playerX + "," + playerY;
        Location location = locations.get(key);
        if (location != null) {
            return location.getDescription();
        }
        return "Unknown location.";
    }*/
    public String getCurrentLocation() {
        return currentLocation.getDescription();
}
}