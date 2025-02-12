public class PatternTraingle2 {
    public static void main(String[] args) {
        int n = 4, num = n - 1;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                System.out.print(num);
            }
            num++;
            System.out.println();
        }
        num--;
        for(int i = n - 1; i >= 1; i--)
        {
            num--;
            for(int j = 1; j <= i; j++) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
