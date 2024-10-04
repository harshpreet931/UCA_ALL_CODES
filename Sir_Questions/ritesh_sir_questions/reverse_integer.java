public class reverse_integer {
    public static void main(String[] args) {
        System.out.println(reverse_integer(123));
        System.out.println(reverse_integer(-123));
        System.out.println(reverse_integer(120));
        System.out.println(reverse_integer(0));
        System.out.println(reverse_integer(1534236469));
    }

    public static int reverse_integer(int x)
    {
        int res = 0;
        boolean isNeg = x < 0;
        x = Math.abs(x);

        while(x > 0)
        {
            int dig = x % 10;
            x /= 10;

            if(res > (Integer.MAX_VALUE - dig) / 10) return 0;

            res = res * 10 + dig;
        }

        return isNeg ? -res : res;
    }
}
