package JavaCollections.AdventureGame;

//Made immutable
//Meaning once its created it cant be changed


import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer> exits;


    public Location(int locationID, String description, Map<String, Integer>exits) {//initialises:
        this.locationID = locationID;//locations
        this.description = description;//descriptions
        this.exits = new HashMap<String, Integer>(exits);//the empty exits
        this.exits.put("Q",0);//and adds an exit to all of them
    }

//    public void addExit(String direction, int location){
//        exits.put(direction, location);//adds exits}

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;//returns the location
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);//returns all exits
    }

}
