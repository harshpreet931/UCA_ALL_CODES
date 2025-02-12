import java.util.*;

public class climbstairs {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(helper(n));
    }

    static Integer[] memo = new Integer[50];
    private static int helper(int n)
    {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(memo[n] != null) return memo[n];
        return memo[n] = helper(n - 1) + helper(n - 2);
    }

    private static int helper2(int[] arr, int k)
    {
        Map<Integer, Integer> mp = new HashMap<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int compl = k - arr[i];
            if(mp.containsKey(compl)) count += mp.get(compl);
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}
