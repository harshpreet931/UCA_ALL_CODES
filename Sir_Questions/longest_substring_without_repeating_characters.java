import java.util.*;

public class longest_substring_without_repeating_characters {
    public static void main(String[] args) 
    {
        String temp1 = "abcabcbb";
        String temp2 = "bbbbb";
        String temp3 = "pwwkew";
        String temp4 = "";

        assert helper(temp1) == 3 : "Test Case 1 Failed";
        assert helper(temp2) == 1 : "Test Case 2 Failed";
        assert helper(temp3) == 3 : "Test Case 3 Failed";
        assert helper(temp4) == 0 : "Test Case 4 Failed";
        System.out.println("All test cases passed!");
    }

    private static int helper(String s)
    {
        if(s.length() < 1) return 0;
        Map<Character, Integer> mp = new HashMap<>();
        int res = 0;

        for(int l = 0, r = 0; r < s.length(); r++) 
        {
            char c = s.charAt(r);
            while(mp.containsKey(c))
            {
                char toDel = s.charAt(l);
                mp.put(toDel, mp.get(toDel) - 1);
                if(mp.get(toDel) == 0) mp.remove(toDel);
                l++;
            }
            mp.put(c, mp.getOrDefault(c, 0) + 1);
            res = Math.max(res, r - l + 1);
        }

        return res;
    }   
}
