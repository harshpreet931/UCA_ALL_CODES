package very_simple_practice_questions;
import java.util.*;
public class prc_09 {
    // Sample Input
    // 1
    // 4
    // 54 546 548 60
    // Sample Output
    // 6054854654
    // Explanation
    // Upon rearranging the elements of the array , 6054854654 is the largest possible number that can be generated.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
            
            // without custome comparator
            // using bubble sort
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n-i-1; j++) {
                    String x = arr[j] + "" + arr[j+1];
                    String y = arr[j+1] + "" + arr[j];
                    if(Integer.parseInt(x) < Integer.parseInt(y)) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }

            for(int i = 0; i < n; i++) System.out.print(arr[i]);
            System.out.println();
        }
    }
}
