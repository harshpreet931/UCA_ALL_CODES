import java.util.*;

public class KSizePairWithEvenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        List<List<Integer>> res = kSizePairWithEvenSum(arr, k);
        for(List<Integer> list : res) System.out.println(list);
    }

    private static List<List<Integer>> kSizePairWithEvenSum(int[] arr, int k)
    {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> window = new ArrayList<>();
        for(int i = 0; i < k; i++) window.add(arr[i]);

        if(isEvenSum(window)) res.add(new ArrayList<>(window));

        for(int i = k; i < arr.length; i++)
        {
            window.remove(0);
            window.add(arr[i]);
            if(isEvenSum(window)) res.add(new ArrayList<>(window));
        }

        return res;
    }

    private static boolean isEvenSum(List<Integer> window)
    {
        int sum = 0;
        for(int num : window) sum += num;
        return sum % 2 == 0;
    }
}
