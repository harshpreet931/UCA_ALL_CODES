import java.util.*;

public class fruits_into_baskets 
{
    private static int helper(int[] arr)
    {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0, n = arr.length;

        for(int i = 0, j = 0; j < n; j++) 
        {
            mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1);

            while(mp.size() > 2)
            {
                int freq = mp.get(arr[i]);
                mp.put(arr[i], freq - 1);
                if(freq-1 == 0) mp.remove(arr[i]);
                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) 
    {
        int[] temp1 = {1, 2, 1};
        int[] temp2 = {0, 1, 2, 2};
        int[] temp3 = {1, 2, 3, 2, 2};
        int[] temp4 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        assert helper(temp1) == 3 : "Test Case 1 Failed";
        assert helper(temp2) == 3 : "Test Case 2 Failed";
        assert helper(temp3) == 4 : "Test Case 3 Failed";
        assert helper(temp4) == 5 : "Test Case 4 Failed";
        System.out.println("All test cases passed!");    
    }
}
