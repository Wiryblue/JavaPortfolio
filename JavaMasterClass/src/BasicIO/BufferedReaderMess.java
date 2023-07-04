package BasicIO;

import java.io.*;

public class BufferedReaderMess {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("I like cheese");
            writer.close(); // you need this or else we won't get an output
        }
        catch (IOException e){
            e.getStackTrace();
            //buffered Reader is a Scanner
        }

    }
}
