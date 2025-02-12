import java.util.*;

public class PrimeBank {
    public static void main(String[] args) {
        printPrime(100, 3);
    }

    private static void printPrime(int num, int digit)
    {
        int currNum = num;
        int maxNum = (int) Math.pow(10, digit);

        while(currNum < maxNum)
        {
            if(isPrime(currNum))
                System.out.println(currNum);
            currNum++;
        }
    }

    private static boolean isPrime(int num)
    {
        if(num < 2)
            return false;

        for(int i = 2; i * i <= num; i++)
        {
            if(num % i == 0)
                return false;
        }

        return true;
    }
}
