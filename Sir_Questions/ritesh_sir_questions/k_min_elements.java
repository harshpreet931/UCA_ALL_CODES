import java.util.Arrays;
import java.util.PriorityQueue;

public class k_min_elements 
{   
    // Time complexity: O(nlogn)
    // public static int[] findMin(int[] arr, int k)
    // {
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //     for(int i = 0; i < arr.length; i++)
    //     {
    //         minHeap.add(arr[i]);
    //     }

    //     int[] result = new int[k];
    //     for(int i = 0; i < k; i++)
    //     {
    //         result[i] = minHeap.poll();
    //     }
    //     return result;
    // }

    // Time complexity: O(nlogk)
    // public static int[] findMin(int[] arr, int k)
    // {
    //     PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

    //     for(int i = 0; i < arr.length; i++)
    //     {
    //         maxHeap.add(arr[i]);
    //         if(maxHeap.size() > k)
    //         {
    //             maxHeap.poll();
    //         }
    //     }

    //     int[] result = new int[k];
    //     for(int i = 0; i < k; i++)
    //     {
    //         result[k - i - 1] = maxHeap.poll();
    //     }
    //     return result;
    // }

    // Quick Select
    public static int[] findMin(int[] arr, int k)
    {
        quickSelect(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void quickSelect(int[] arr, int start, int end, int k)
    {
        if(start < end)
        {
            int pivot = partition(arr, start, end);
            if(pivot == k)
            {
                return;
            }
            else if(pivot < k)
            {
                quickSelect(arr, pivot + 1, end, k);
            }
            else
            {
                quickSelect(arr, start, pivot - 1, k);
            }
        }
    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[end];
        int i = start;
        for(int j = start; j < end; j++)
        {
            if(arr[j] <= pivot)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 7, 2, 1, 9};
        int k = 3;
        int[] result = findMin(arr, k);
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}