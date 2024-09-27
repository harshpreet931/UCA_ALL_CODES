import java.util.*;

public class top_k_frequent 
{
    public static int[] topKFrequent(int[] nums, int k)
    {
        if(k == nums.length) return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for(int num : map.keySet())
        {
            minHeap.add(num);
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++)
        {
            result[k - i - 1] = minHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(arr, k);
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}
