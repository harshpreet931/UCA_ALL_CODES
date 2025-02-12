public class DiePossiblitiesOfASum {
    public static void main(String[] args) {
        int dies = 3;
        int sum = 5;
        System.out.println(helper(dies, sum));
    }

    private static int helper(int n, int sum)
    {
        if(sum < 0) return 0;
        if(n == 0 && sum == 0) return 1;
        if(n == 0 || sum == 0) return 0;

        int count = 0;
        for(int i = 1; i <= 6; i++) {
            count += helper(n - 1, sum - i);
        }

        return count;
    }
}
