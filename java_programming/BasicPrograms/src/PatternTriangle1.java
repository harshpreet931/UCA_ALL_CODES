public class PatternTriangle1 {
    public static void main(String[] args) {
        int n = 5;
        int start = 1;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(start);
                    if (j < i)
                        System.out.print("*");
                    start++;
                }
            } else {
                int temp = start + i;
                for (int j = 1; j <= i; j++) {
                    temp--;
                    System.out.print(temp);
                    if (j < i)
                        System.out.print("*");
                    start++;
                }
            }
            System.out.println();
        }
    }
}
