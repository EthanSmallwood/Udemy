package JavaCollections.AdventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);//scanner for inputs
    private static Map<Integer,Location>locations = new HashMap<Integer,Location>();//local hashmap which makes Location objects

    public static void main(String[] args) {
        //Locations
        //Locations are stored as a hashmap which out puts text based on the numerical ID
        //This is used to navigate around the area using N,E,S,W
        /*
        locations.put(0, new Location(0, "You are sitting in front of a computer"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));*/

        //THIS CHANGE IS AFTER YOU CHANGE THE CONSTRUCTOR TO ADD " Map<String, Integer>exits" this is to make the location.java immutable
        Map<String, Integer >tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));

        //Exits
        //This is the possible exit each location has.
        /*
        //1 Road
        locations.get(1).addExit("N",5);
        locations.get(1).addExit("E",3);
        locations.get(1).addExit("S",4);
        locations.get(1).addExit("W",2);
        //2 Hill
        locations.get(2).addExit("N",5);
        //3 Building
        locations.get(3).addExit("W",1);
        //4 Valley
        locations.get(4).addExit("N",1);
        locations.get(4).addExit("W",2);
        //5 Forest
        locations.get(5).addExit("S",1);
        locations.get(5).addExit("W",2);
        */

        //Vocabulary converts
        //This takes an input of a word and turns it into something like Q
        Map<String,String> vocabulary = new HashMap<String,String>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("EAST","E");
        vocabulary.put("SOUTH","S");
        vocabulary.put("WEST","W");

        int loc = 1; //initial location starts at the road(1)
        while(true){ //starts loop
            System.out.println(locations.get(loc).getDescription());//displays the players current position

            if(loc==0){break;} //if location = 0 will display a message then exit the program

            Map<String,Integer>exits = locations.get(loc).getExits();//gets all the exits for the location
            System.out.print("Available exits are ");//shows all exits
            for(String exit: exits.keySet()){ System.out.print(exit+", "); }//loops through all options
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();//gets user inputs can coverts it to uppercase for the hashmap

            if(direction.length()>1){//checks to see if the string is longer than 1 letter
                String[] words = direction.split(" ");//splits the string up to individual items everytime theres a space
                for(String word: words){//loop
                    if(vocabulary.containsKey(word)){//checks to see if the word is in the vocab map
                        direction = vocabulary.get(word);//sets the direction to the letter equivalent
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)){//checks to see if the direction entered is valid
                loc = exits.get(direction);//saves direction
            }else{
                System.out.println("You can not go in that direction");//says its an invalid move
            }
        }
    }
}
