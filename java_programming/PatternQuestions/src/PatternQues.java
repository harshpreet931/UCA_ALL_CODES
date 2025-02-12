public class PatternQues {
    public static void main(String[] args) {
        pattern1(5);
        System.out.println();
        pattern2(5);
        System.out.println();
        pattern3(5);
        System.out.println();
        pattern4(5);
        System.out.println();
        pattern5(5);
        System.out.println();
        pattern6(4);
        System.out.println();
        pattern7(5);
    }

    private static void pattern1(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    private static void pattern2(int n)
    {
        for(int i = n; i >= 1; i--)
        {
            for(int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    private static void pattern3(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for(int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    private static void pattern4(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for(int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
        for(int i = n - 1; i >= 1; i--)
        {
            for(int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for(int j = 1; j <= 2 * i - 1; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    private static void pattern5(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for(int j = 1; j <= i; j++)
                System.out.print(j);
            for(int j = i - 1; j >= 1; j--)
                System.out.print(j);
            System.out.println();
        }
    }

    private static void pattern6(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= i; j++)
                System.out.print("*");
            for(int j = 1; j <= 2 * (n - i); j++)
                System.out.print(" ");
            for(int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
        for(int i = n - 1; i >= 1; i--)
        {
            for(int j = 1; j <= i; j++)
                System.out.print("*");
            for(int j = 1; j <= 2 * (n - i); j++)
                System.out.print(" ");
            for(int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    private static void pattern7(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for(int j = 1; j <= 2 * i - 1; j++)
            {
                if(j == 1 || j == 2 * i - 1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
        for(int i = n - 1; i >= 1; i--)
        {
            for(int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for(int j = 1; j <= 2 * i - 1; j++)
            {
                if(j == 1 || j == 2 * i - 1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

}
