public class peak_element {
    private static int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }

        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] temp1 = {1, 2, 3, 1};
        int[] temp2 = {1, 2, 1, 3, 5, 6, 4};
        
        assert findPeakElement(temp1) == 2 : "Test Case 1 Failed";
        assert findPeakElement(temp2) == 5 : "Test Case 2 Failed";
        System.out.println("All test cases passed!");
    }
}
