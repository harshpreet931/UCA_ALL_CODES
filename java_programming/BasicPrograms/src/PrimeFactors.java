public class PrimeFactors {
    public static void main(String[] args) {
        int num = 315;
        System.out.print("Prime factors of " + num + " are: ");
        primeFactors(num);
    }

    private static void primeFactors(int num)
    {
        for(int i = 2; i <= num; i++)
        {
            while(num % i == 0)
            {
                System.out.print(i + " ");
                num /= i;
            }
        }
    }
}
