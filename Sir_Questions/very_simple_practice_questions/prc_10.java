package very_simple_practice_questions;
import java.util.*;
public class prc_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = "";

        int i = 0; 
        while(i < str.length()) {
            res += str.charAt(i);
            while(i + 1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
                i++;
            }
            i++;
        }

        System.out.println(res);
    }
}
