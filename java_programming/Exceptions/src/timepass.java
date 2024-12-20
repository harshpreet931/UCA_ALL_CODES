import java.util.*;

public class timepass {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,4,4,5,5,5,5,6,7,7};
        int sum = helper(arr);
        System.out.println(sum);
    }

    private static int helper(int[] arr)
    {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : arr) mp.put(i, mp.getOrDefault(i, 0) + 1);
        int sum = 0;

        for(Map.Entry<Integer, Integer> entry : mp.entrySet())
        {
            if(entry.getValue() % 2 == 1)
            {
                sum += entry.getKey();
            }
        }

        return sum;
    }
}
