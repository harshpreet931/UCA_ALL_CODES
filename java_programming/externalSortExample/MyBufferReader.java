import java.util.*;
import java.io.*;

public class MyBufferReader implements Comparable<MyBufferReader> {

    private final File tempFile;
    private Integer currentNumber;
    public boolean hasNumber = false;

    private BufferedReader br;

    public MyBufferReader(File tempFile) throws IOException {
        this.tempFile = tempFile;
        br = new BufferedReader(new FileReader(this.tempFile));

        reload();
    }

    private void reload() throws IOException {
        String s = br.readLine();

        if (s == null) {
            hasNumber = false;
            currentNumber = null;
        }
        else {
            currentNumber = Integer.parseInt(s);
            hasNumber = true;
        }
    }

    public void close() throws IOException {
        this.br.close();
    }

    public int peek() {
        return currentNumber;
    }

    public int pop() throws IOException {
        int temp = peek();
        reload();
        return temp;
    }

    @Override
    public int compareTo(MyBufferReader o)
    {
        return this.currentNumber - o.currentNumber;
    }
}
