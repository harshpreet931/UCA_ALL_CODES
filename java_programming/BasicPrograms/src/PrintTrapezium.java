public class PrintTrapezium {
    public static void main(String[] args) {
        int n = 4, num = 1, k = 1, spaces = 0;

        for(int i = 0; i < n; i++)
        {
            System.out.print("-".repeat(spaces));
            for(int j = 0; j < n - i; j++)
                System.out.print(num++ + (j < n - i - 1 ? "*" : ""));
            System.out.print('*');

            int rightStart = k + (n - i) * (n - i);
            for(int j = 0; j < n - i; j++)
            {
                System.out.print(rightStart++ + (j < n - i - 1 ? "*" : ""));
                k++;
            }

            spaces += 2;
            System.out.println();
        }
    }
}
