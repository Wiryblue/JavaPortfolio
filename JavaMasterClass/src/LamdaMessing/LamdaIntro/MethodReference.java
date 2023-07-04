package LamdaMessing.LamdaIntro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Ann", "Bob", "Chuck", "Dave"));

        list.forEach(System.out::println);
        calculator(Integer::sum, 10, 23);
    }


    private static <T> void calculator(BinaryOperator<T> func, T t1, T t2){
        T result = func.apply(t1,t2);
        System.out.println("Result of Operation " + result);
    }
}
