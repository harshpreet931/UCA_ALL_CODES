import java.util.*;

public class next_greater_element {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        for(int i = nums.length-1; i>=0; i--) s.push(nums[i]);

        for(int i = nums.length-1; i>=0; i--) {
            int num = nums[i];
            while(!s.isEmpty() && s.peek() <= num) s.pop();

            nums[i] = s.isEmpty() ? -1 : s.peek();
            s.push(num);
        }

        return nums;
    }

    public static void main(String[] args) {
        next_greater_element nge = new next_greater_element();
        int[] nums = {1, 2, 1};
        int[] res = nge.nextGreaterElements(nums);
        int[] expected = {2, -1, 2};
        assert Arrays.equals(res, expected) : "Test Case 1 Failed";

        System.out.println("All test cases passed!!");
    }
}
