import java.util.*;
public class InputTesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int k = sc.nextInt();
        sc.nextLine();
        String[] vals = sc.nextLine().trim().split(" ");

        System.out.println(n);
        System.out.println(k);
        System.out.println(Arrays.toString(vals));
    }
}
