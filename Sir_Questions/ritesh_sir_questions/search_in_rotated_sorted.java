public class search_in_rotated_sorted 
{
    public static void main(String[] args) 
    {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        assert bs(arr, target) == 4 : "Test case 1 failed";
        System.out.println("Test case 1 passed!");
    }

    private static int bs(int[] arr, int target)
    {
        int start = 0, end = arr.length - 1;
        while(start <= end)
        {
            int mid = (start + end) / 2;

            if(arr[mid] == target) return mid;
            if(arr[mid] >= arr[start])
            {
                if(arr[start] <= target && arr[mid] > target) end = mid - 1;
                else start = mid + 1; 
            }
            else
            {
                if(arr[mid] < target && arr[end] >= target) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}
