import java.util.*;
public class generate_parantheses {
    public static void main(String[] args) {
        List<String> res = gen(3);
        
        System.out.println(res);
    }

    public static List<String> gen(int n)
    {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }

    public static void helper(List<String> res, String s, int open, int close, int n)
    {
        if(close == n)
        {
            res.add(s);
            return;
        }

        if(open < n)
        {
            helper(res, s + "(", open + 1, close, n);
        }

        if(close < open)
        {
            helper(res, s + ")", open, close + 1, n);
        }
    }
}
