import java.util.*;
import java.util.stream.Collectors;
class fibonacci
{
    public static void main(String[] args) {
        ArrayList<Integer> res = nextLargerElement(new int[]{4, 5, 2, 10, 8});
        System.out.println(res);
    }

    public static long helper(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> s = new Stack<>();
        
        for(int i = arr.length - 1; i >= 0; i--)
        {
            int num = arr[i];
            while(!s.isEmpty() && s.peek() <= num) s.pop();
            arr[i] = s.isEmpty() ? -1 : s.peek();
            s.push(num);
        }
        
                return Arrays.stream(arr)
                     .boxed()
                     .collect(Collectors.toCollection(ArrayList::new));
    }
}