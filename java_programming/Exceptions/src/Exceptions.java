import java.util.*;

public class Exceptions {

    private boolean onlyDigits(String str)
    {
        for(int i = 0; i < str.length(); i++)
        {
            if(!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    public List<Integer> superPrimes(String str)
    {
        try {
            if(str == null || str.isEmpty())
            {
                throw new IllegalArgumentException("Input is null or empty");
            }
            if(!onlyDigits(str))
            {
                throw new BadRequestException("Invalid input contains non-digit characters");
            }

            if(Integer.parseInt(str) > 1000)
            {
                throw new BadRequestException("Input number is too large (greater than 1000)");
            }
        } catch (BadRequestException | IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }

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
        Exceptions sp = new Exceptions();
        List<Integer> res = sp.superPrimes("10000");
        List<Integer> res2 = sp.superPrimes("10a");
        List<Integer> res3 = sp.superPrimes(null);
        List<Integer> res4 = sp.superPrimes("1000");
        for(int i : res4)
        {
            System.out.print(i + " ");
        }
    }
}
