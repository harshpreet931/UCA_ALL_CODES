public class PatternSquare1 {
    public static void main(String[] args) {
        int n = 3;
        for(int i = 1; i <= n; i++)
        {
            int rowNum = i;
            if(i % 2 == 1)
            {
                for(int j = 1; j <= 4 - 1; j++)
                {
                    System.out.print(rowNum);
                }
                System.out.print(rowNum + 1);
            }
            else
            {
                System.out.print(rowNum + 1);
                for(int j = 1; j <= 4 - 1; j++) {
                    System.out.print(rowNum);
                }
            }
            System.out.println();
        }
    }
}
