package LamdaMessing;

public class LamdaMess {
    // quick way to crate an implementation for Functional Interface
    public static void main(String[] args) {
        printPrintable((input) -> {
            System.out.println("Fight me" + input);
            return input;
        });

    }

    static void printPrintable(Printable thing) {
        thing.print("!");
    }

}
