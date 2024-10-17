package ritesh_sir_questions;
import java.util.*;

public class sort_vowels {
    public static void main(String[] args) {
        String s = "leetcode";
        sort_vowels obj = new sort_vowels();
        System.out.println(obj.sortVowels(s));
    }
    
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        
        int[] counts = new int[256];
        for (char c : s.toCharArray()) 
        {
            if (isVowel(c)) counts[c]++;
        }
        
        String vowels = "AEIOUaeiou";
        int idx = 0;
        
        for (char c : s.toCharArray()) 
        {
            if (!isVowel(c)) sb.append(c);
            else 
            {
                while (idx < vowels.length() && counts[vowels.charAt(idx)] == 0) idx++;
                sb.append(vowels.charAt(idx));
                counts[vowels.charAt(idx)]--;
            }
        }
        
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}