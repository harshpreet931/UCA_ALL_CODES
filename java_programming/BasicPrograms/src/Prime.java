public class Prime {
    public static void main(String[] args) {
        primesBelowN(20);
    }

    private static void primesBelowN(int n)
    {
        for(int i = 2; i <= n; i++)
        {
            if(isPrime(i)) System.out.print(i + " ");
        }
    }

    private static boolean isPrime(int n)
    {
        if(n < 2) return false;

        for(int i = 2; i * i <= n; i++)
        {
            if(n % i == 0) return false;
        }
        return true;
    }
}
