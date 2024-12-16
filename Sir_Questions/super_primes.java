package sir_questions;
import java.util.*;

public class super_primes {
    // 2 <= i <= n and i is a prime and i/10 is also a super prime
    public List<Integer> superPrimes(String str)
    {
        int n = Integer.parseInt(str);
        List<Integer> res = new ArrayList<>();
        for(int i = 2; i <= n; i++)
        {
            int temp = i;
            boolean flag = true;
            while(temp > 0)
            {
                if(!isPrime(temp))
                {
                    flag = false;
                    break;
                }
                temp /= 10;
            }
            if(flag)
            {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isPrime(int n)
    {
        if(n <= 1) return false;
        if(n % 2 == 0) return false;
        for(int i = 2; i <= Math.sqrt(n); i++)
        {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        super_primes sp = new super_primes();
        List<Integer> res = sp.superPrimes("100");
        for(int i : res)
        {
            System.out.print(i + " ");
        }
    }
}
