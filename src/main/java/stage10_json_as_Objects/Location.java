package stage10_json_as_Objects;
import java.util.Map;

public class Location {
    private String name;
    private String description;
    private String detailedDescription;
    private Map<String, String> exits;  // Map to store exits (north, east, south, west)

    // Getters and setters for Gson
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public Map<String, String> getExits() {
        return exits;
    }

    public void setExits(Map<String, String> exits) {
        this.exits = exits;
    }
}