import java.util.*;

public class SpecialSorting {
    // special sorting where 0 has the maximum priority
    // and all other numbers are sorted in ascending order
    // the negative and positive numbers have same priority and negative comes first
    // input: [1, 2, 0, -1, -2]
    // output: [-1, 1, -2, 2, 0]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        specialSort(arr);
    }

    private static void specialSort(int[] arr)
    {
        int zeroCount = 0;
        List<Integer> res = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b)) return a - b;
            return Math.abs(a) - Math.abs(b);
        });

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 0) zeroCount++;
            else pq.add(arr[i]);
        }

        while(!pq.isEmpty()) System.out.print(pq.poll() + " ");
        for(int i = 0; i < zeroCount; i++) System.out.print(0 + " ");
    }
}
