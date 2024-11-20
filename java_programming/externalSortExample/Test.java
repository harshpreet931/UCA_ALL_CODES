import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        File f = new File("input.txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter((f)));

        Random r = new Random();

        for (int i = 0; i < 200; i++) {
            bw.write(r.nextInt(200) + "");
            bw.newLine();
        }

        bw.close();

        ExternalSort externalSort = new ExternalSort(f);

        externalSort.sort();
    }
}
