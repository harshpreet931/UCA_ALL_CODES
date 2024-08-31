package very_simple_practice_questions;
import java.util.*;
public class prc_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = "";

        for(int i = 0; i < str.length()-1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);

            if(res.isEmpty()) res = res + c1 + (int)(c2 - c1) + c2;
            else res = res + (int)(c2 - c1) + c2;
        }

        System.out.println(res);
    }
}
