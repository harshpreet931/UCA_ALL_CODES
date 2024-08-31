package very_simple_practice_questions;
import java.util.*;
public class prc_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = "";

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(((c - 'a') % 2) == 0) res = res + (char)(c + 1);
            else res = res + (char)(c - 1);
        }

        System.out.println(res);
    }
}
