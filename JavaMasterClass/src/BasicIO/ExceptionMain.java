package BasicIO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {
//        int x = 98;
//        int y = 0;
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEaFP(x,y));
//        System.out.println(divide(x,y));
        int x = getIntEAFP();
        System.out.println(x);
    }
    private static int getInt(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    private static int getIntLBYL(){
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String input = s.next();
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if(isValid){
            return Integer.parseInt(input);
        }
        return 0;
    }
    private static int getIntEAFP(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a integer ");
        try{
            return s.nextInt();
        }catch (InputMismatchException e){
            return 0;
        }
    }
    private static int divideLBYL(int x, int y){
        if(y != 0){
            return x/y;
        }
        else{
            return 0;
        }
    }
    private static int divideEaFP(int x, int y){
        try{
            return x / y;
        }
        catch (ArithmeticException e){
            return 0;
        }
    }
    private static int divide(int x, int y){
        return x / y;
    }
}
