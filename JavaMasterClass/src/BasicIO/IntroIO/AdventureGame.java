package BasicIO.IntroIO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {

    private static Locations locations = new Locations();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
