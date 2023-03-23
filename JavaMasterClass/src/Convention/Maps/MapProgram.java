package Convention.Maps;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String,String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level language");
        languages.put("Python", "It's an easy one that is high level");
        languages.put("Algol", "an algorithmic one"); // adding the same value again overwrites
        languages.put("BASIC", "Beginner All Purposes Symbolic Instruction CODE");
        languages.put("Lisp", "Therein lies madness"); // if try to print return null

        System.out.println(languages.get("Java"));
        System.out.println(languages.get("Python"));
        System.out.println(languages.get("BASIC"));
        System.out.println(languages.get("Algol"));
        System.out.println(languages.get("Lisp"));

        if(languages.containsKey("Java")){
            System.out.println("YOOOO WE HAVE JAVA LETS GOOOOO");
        }

        for (String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
        if(languages.remove("Algol","an algorithmic one")){
            System.out.println("Algol removed");
        }
        else{
            System.out.println("Algol not removed, key/value pair not found.");
        }

        languages.replace("Java", "a compiled high level language", "AHHHHHHH");
    }
}
