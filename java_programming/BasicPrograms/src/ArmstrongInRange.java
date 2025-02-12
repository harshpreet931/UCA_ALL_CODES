public class ArmstrongInRange {
    public static void main(String[] args) {
        ArmstrongInRangePrint(10, 100000000);
    }

    private static void ArmstrongInRangePrint(int start, int end)
    {
        for(int i = start; i <= end; i++)
            if(isArmstrong(i)) System.out.print(i + " ");
    }

    private static boolean isArmstrong(int num)
    {
        int sum = 0;
        int temp = num;
        int n = String.valueOf(num).length();

        while(temp > 0)
        {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, n);
            temp /= 10;
        }

        return sum == num;
    }
}
