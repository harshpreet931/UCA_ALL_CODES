package externalSort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {

        // Creating a file say input.txt
        File f = new File("input.txt");

        // Automatically Handling the Flush
        BufferedWriter bw = new BufferedWriter(new FileWriter((f)));

        Random r = new Random();

        for (int i = 0; i < 200; i++) {
            bw.write(r.nextInt(200) + "");
            bw.newLine();
        }

        bw.close();

        System.out.println(f.length());

        // To Find Out How much memory left in my RAM
        System.out.println(Runtime.getRuntime().freeMemory());

        ExternalSort externalSort = new ExternalSort(f);

        externalSort.sort();
    }
}
