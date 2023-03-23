package Convention.Adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExits = new HashMap<>();
        locations.put(0, new Location(0, "Welcome to the Backrooms", (HashMap<String, Integer>) tempExits));


        tempExits = new HashMap<>();
        tempExits.put("W", 2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "SLAUGHTER CHAMBER Entered", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "AP JAVA Classroom", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locations.put(4, new Location(4, "In a valley", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 2);
        tempExits.put("S", 1);
        locations.put(5, new Location(5, "You are in a forest", tempExits));


        Map<String, String> voacab = new HashMap<String, String>();
        voacab.put("QUIT", "Q");
        voacab.put("NORTH", "N");
        voacab.put("SOUTH", "S");
        voacab.put("WEST", "W");
        voacab.put("EAST", "E");


        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available Exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String directions = scanner.nextLine().toUpperCase();

            if (exits.containsKey(directions)) {
                loc = exits.get(directions);
            } else {
                System.out.println("You cannot go in that direction");
            }
            if (!locations.containsKey(loc)) {
                System.out.println("You cannot go in that direction");
            }
        }
    }


}
