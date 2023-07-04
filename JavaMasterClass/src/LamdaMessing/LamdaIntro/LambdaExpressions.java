package LamdaMessing.LamdaIntro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        System.out.println("-------------");
        list.forEach((theFuckenString) -> System.out.println(theFuckenString));

        System.out.println("-------------");
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(s -> System.out.println(s));


        System.out.println("-------------");
        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " +myString + " means " + first);
        });

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        System.out.println("-------------");
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " +myString + " means " + first);
        });

        System.out.println("--------------------------");

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.fill(emptyStrings,"");
        System.out.println(Arrays.toString(emptyStrings));

        System.out.println("--------------------------");

        Arrays.setAll(emptyStrings, i -> "" +(i+1) + ". "
        + switch (i){
            case 0 -> "one";
            case 1 -> "two";
            case 2 -> "three";
            default -> "";
        });
        System.out.println(Arrays.toString(emptyStrings));


    }
}
