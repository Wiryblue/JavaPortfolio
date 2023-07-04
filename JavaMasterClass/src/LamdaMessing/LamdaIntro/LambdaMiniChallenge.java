package LamdaMessing.LamdaIntro;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaMiniChallenge {
    public static void main(String[] args) {
        Consumer<String> printTheParts = new Consumer<String>() {
            @Override
            public void accept(String sentence){
                String[] parts = sentence.split(" ");
                for(String part: parts){
                    System.out.println(part);
                }
            }
        };


        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts){
                System.out.println(part);
            }
        };

        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };

        printTheParts.accept("Lets split this up into an array.");

        System.out.println("----------------------------------------------");

        printWordsLambda.accept("Lets split this up into an array.");

        System.out.println("----------------------------------------------");

        printWordsForEach.accept("Lets split this up into an array.");

        Function<String,String>  everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(everySecondChar.apply("1234567890"));

        System.out.println(everySecondChar(everySecondChar, "1234567890"));

        Supplier<String> iLoveJava = () -> "I love Java";

        System.out.println(iLoveJava.get());

    }
    public static String everySecondChar(Function<String, String> function, String source){
        return function.apply(source);
    }
}
