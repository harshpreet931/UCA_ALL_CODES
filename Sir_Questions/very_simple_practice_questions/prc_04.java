package very_simple_practice_questions;
import java.util.*;

public class prc_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = "";
        for(int i = 0; i < str.length(); i++) {
            if(isUpperCase(str.charAt(i))) res = res + Character.toLowerCase(str.charAt(i));
            else res = res + Character.toUpperCase(str.charAt(i));
        }
        System.out.println(res);
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
