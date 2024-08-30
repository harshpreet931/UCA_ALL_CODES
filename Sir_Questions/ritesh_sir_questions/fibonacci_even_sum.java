import java.util.Scanner;
public class fibonacci_even_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 1, c = 1;
        int sum = 0;

        while(c <= n) {
            if(c % 2 == 0) {
                System.out.println(c);
                sum += c;
            }
            a = b;
            b = c;
            c = a + b;
        }

        System.out.println(sum);
        sc.close();
    }
}
