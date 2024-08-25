public class reverse_interger 
{
    public static int reverse(int x)
    {
        boolean isNegative = x < 0;
        x = Math.abs(x);
        int ans = 0;

        while(x != 0)
        {
            int digit = x % 10;
            x /= 10;

            if(ans > (Integer.MAX_VALUE - digit) / 10)
            {
                return 0;
            }

            ans  = ans * 10 + digit;
        }

        return isNegative ? -ans : ans;
    }

    public static void main(String[] args) {
        assert reverse(123) == 321 : "Test Case 1 Failed";
        assert reverse(-123) == -321 : "Test Case 2 Failed";
        assert reverse(120) == 21 : "Test Case 3 Failed";
        System.out.println("All Test Cases Passed");
    }
}
