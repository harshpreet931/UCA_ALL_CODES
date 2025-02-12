public class timepass {
    public static void main(String[] args) {
        int start = 1;
        for (int i = 1; i <= 5; i++)
        {
            if (i % 2 == 0)
            {
                int end = start + i - 1;
                for (int j = end; j >= start; j--)
                    System.out.print(j + "*");
                start = end + 1;
            }
            else
            {
                for (int j = start; j < start + i; j++) {
                    if (j == start + i - 1)
                        System.out.print(j);
                    else
                        System.out.print(j + "*");
                }
                start = start + i;
            }
            System.out.println();
        }
    }
}
