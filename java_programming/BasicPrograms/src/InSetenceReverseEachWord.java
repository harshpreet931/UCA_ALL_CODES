import java.util.Scanner;

public class InSetenceReverseEachWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] words = sentence.split(" ");
        for(String s : words)
            System.out.print(new StringBuilder(s).reverse() + " ");
    }
}
