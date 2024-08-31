package very_simple_practice_questions;
import java.util.*;
public class prc_08 {
    public static void main(String[] args) {
        // length of the longest subtring with only vowels
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int maxi = 0;
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(isVowel(str.charAt(i))) {
                count++;
                maxi = Math.max(maxi, count);
            } else {
                count = 0;
            }
        }
        
        System.out.println(maxi);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
