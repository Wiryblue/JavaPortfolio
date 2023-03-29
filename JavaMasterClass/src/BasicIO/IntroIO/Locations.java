package BasicIO.IntroIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {


        try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter("directions.txt")) {
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }


//        FileWriter locFile = null;
//        try {
//           locFile = new FileWriter("location.txt");
//           for (Location location : locations.values()) {
//               locFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
//           }
//       }
//       catch (IOException e){
//           System.out.println("In catch block");
//           e.printStackTrace();
//       }finally {
//           System.out.println("In finally Block");
//           try{
//               if(locFile != null) {
//                   System.out.println("Attempting to close locFile");
//                   locFile.close();
//               }
//           }catch (IOException e){
//               e.printStackTrace();
//           }
//
//       }
    }

    static {


        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        try{
            scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
            while(scanner.hasNextLine()){
                int loc = scanner.nextInt();
                String direction = scanner.next();
                scanner.skip(scanner.delimiter());
                String dest = scanner.nextLine();
                int destination = Integer.parseInt(dest);
                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(scanner!= null){
                scanner.close();
            }
        }

//        Map<String, Integer> tempExits = new HashMap<>();
//        locations.put(0, new Location(0, "Welcome to the Backrooms", (HashMap<String, Integer>) tempExits));
//
//
//        tempExits = new HashMap<>();
//        tempExits.put("W", 2);
//        tempExits.put("E", 3);
//        tempExits.put("S", 4);
//        tempExits.put("N", 5);
//        locations.put(1, new Location(1, "SLAUGHTER CHAMBER Entered", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("N", 5);
//        locations.put(2, new Location(2, "AP JAVA Classroom", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("W", 1);
//        locations.put(3, new Location(3, "", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("N", 1);
//        tempExits.put("W", 2);
//        locations.put(4, new Location(4, "In a valley", tempExits));
//
//        tempExits = new HashMap<>();
//        tempExits.put("W", 2);
//        tempExits.put("S", 1);
//        locations.put(5, new Location(5, "You are in a forest", tempExits));
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Integer> keySet() {
        return null;
    }

    @Override
    public Collection<Location> values() {
        return null;
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return null;
    }

}
