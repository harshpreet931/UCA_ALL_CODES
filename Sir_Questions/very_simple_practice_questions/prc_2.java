package very_simple_practice_questions;
import java.util.Scanner;

public class prc_2 {
    public static long stoint(String s) {
        return Long.parseLong(s.replaceAll("[^0-9]", ""));
    }

    public static boolean isCbNumber(String s) {
        long num = stoint(s);
        if (num == 0 || num == 1) return false;

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        for (int prime : primes) {
            if (num == prime) return true;
        }

        for (int prime : primes) {
            if (num % prime == 0) return false;
        }

        return true;
    }

    public static boolean isValid(boolean[] visited, int l, int r) {
        for (int i = l; i < r; i++) {
            if (visited[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();
        
        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                int e = j + i;
                String sub = s.substring(j, e);
                if (isCbNumber(sub) && isValid(visited, j, e)) {
                    count++;
                    for (int k = j; k < e; k++) {
                        visited[k] = true;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}
