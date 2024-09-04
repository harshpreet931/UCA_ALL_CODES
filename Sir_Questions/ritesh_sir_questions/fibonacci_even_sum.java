import java.util.Scanner;
public class fibonacci_even_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 1, b = 1, c = 2;
        // every third number in fibonacci series is even
        int sum = 0;

        while(c <= n) {
            sum += c;
            a = b + c;
            b = c + a;
            c = a + b;
        }

        System.out.println(sum);
        sc.close();
    }
}
