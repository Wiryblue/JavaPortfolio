package LamdaMessing.LamdaIntro;



import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    record Person (String firstName, String lastName){

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Main.Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")));
        var comparatorLastName = new Comparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };
        people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        System.out.println(people);

        interface EnhancedComparator<T> extends Comparator<T>{
             int secondLevel(T o1, T o2);
        }
        var comparatorMixed = new EnhancedComparator<Person>(){
            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }

            @Override
            public int compare(Person o1, Person o2) {

                int result = o1.lastName.compareTo(o2.lastName);
                return (result == 0 ? secondLevel(o1,o2) : result);
            }
        };
        people.sort(comparatorMixed);
        System.out.println(people);

        int calculate = calculator((Integer a, Integer b)-> a+b, 5,4);
        var result2 = calculator((var a, var b)-> (a/b), 12.0,4.2);
        var result3 = calculator((String a, String b) -> a.toUpperCase() + " " + b.toUpperCase(), "Rachith", "Anasuri");
        System.out.println(calculate);

        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659});

        coords.forEach((s) -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double,Double> p1 = (lat, lng) ->
                System.out.format("[lat:%.3f lon:%.3f]%n", lat, lng);

        var firstpoint = coords.get(0);
        processPoint(firstpoint[0], firstpoint[1], p1);

        System.out.println("---------");

        coords.forEach(s -> processPoint(s[0],s[1],p1));

        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names,() -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));
    }
    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1,value2);
        System.out.println("Result of operation " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1,t2);
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s){
        String[] selectedValues = new String[count];
        for(int i = 0; i < count; i++){
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }

}
