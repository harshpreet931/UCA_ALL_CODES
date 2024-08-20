import java.util.*;

public class candy {
    public static void main(String[] args) {
        int temp1[] = {1,0,2};
        int res1 = 5;

        int temp2[] = {1,2,2};
        int res2 = 4;

        assert candy(temp1) == res1 : "Test Case 1 Failed";
        assert candy(temp2) == res2 : "Test Case 2 Failed";

        System.out.println("All test cases passed!!");
    }

    private static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        for(int i = 1; i < n; i++ ) {
            if(ratings[i] > ratings[i-1]) candy[i] = candy[i-1] + 1;
        }

        for(int i = n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) candy[i] = Math.max(candy[i], candy[i+1] + 1);
        }

        int sum = 0;
        for(int i = 0; i < n; i++) sum += candy[i];
        return sum;
    }
}
