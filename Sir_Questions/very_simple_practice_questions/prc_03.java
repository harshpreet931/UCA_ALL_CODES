package very_simple_practice_questions;
import java.util.*;
public class prc_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = "";
        int i = 0;
        while(i < str.length()) {
            char c = str.charAt(i++);
            int count = 1;
            while(i < str.length() && str.charAt(i) == c) {
                i++; count++;
            }
            res = res + c + count;
        }
        System.out.println(res);
    }
}
