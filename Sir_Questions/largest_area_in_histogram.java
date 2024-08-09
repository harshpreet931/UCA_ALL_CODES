import java.util.*;

class largest_area_in_histogram {
    public static void main(String[] args) {
        int[] temp1 = {2, 1, 5, 6, 2, 3};
        int[] temp2 = {2, 4};

        assert helper(temp1) == 10 : "Test Case 1 Failed";
        assert helper(temp2) == 4 : "Test Case 2 Failed";
        System.out.println("All test cases passed!");
    }

    private static int helper(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int res = 0, i = 0;
        while(i <= arr.length) {
            int val = i < arr.length ? arr[i] : 0;
            if(st.empty() || val >= arr[st.peek()]) {
                st.push(i); i++;
            }
            else {
                int h = arr[st.pop()];
                int w = st.empty() ? i : i - st.peek() - 1;
                res = Math.max(res, h * w);
            }
        }
        return res;
    }
}