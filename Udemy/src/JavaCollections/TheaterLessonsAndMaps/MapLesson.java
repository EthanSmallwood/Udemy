package JavaCollections.TheaterLessonsAndMaps;

import java.util.HashMap;
import java.util.Map;

public class MapLesson {

    public static void main(String[] args) {
        Map<String,String> languages = new HashMap<>();
        if(languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        }else{
            System.out.println("Java added");
            languages.put("Java", "is this course");
        }
        languages.put("Java"," a compiled high level, oop independent language");
        languages.put("Python", "a piece of shit language");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "beginners All purpose symbolic instruction code");
        languages.put("Lisp", "Therein lies madness");



        if(languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        }else{
            languages.put("Java", "is this course");
        }

        System.out.println(languages.get("Java"));

        System.out.println("======================================================================");

        //languages.remove("Lisp");
        if(languages.remove("Algol","an algorithmic language")){
            System.out.println("Algol removed");
        }else{
            System.out.println("Algol not removed, key/value pair not found");
        }

        if(languages.replace("Lisp","Therein lies madness","a functioning programing language")){
            System.out.println("Lisp replaced");
        }else{
            System.out.println("Lisp not replaced");
        }

        System.out.println(languages.replace("Scala","big bitch"));//returns null as it doesnt exist

        for(String key : languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }


    }

}
