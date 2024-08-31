package very_simple_practice_questions;
import java.util.*;
public class prc_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int i = 0;
        while(i < str.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(i++));
            while(i < str.length() && !isUpperCase(str.charAt(i))) {
                sb.append(str.charAt(i));
                i++;
            }
            System.out.println(sb.toString());
        }
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
