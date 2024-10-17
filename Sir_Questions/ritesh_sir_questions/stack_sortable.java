package ritesh_sir_questions;
import java.util.*;

public class stack_sortable 
{
    public static boolean helper(int[] arr) 
    {
        Stack<Integer> stk = new Stack<>();
        int n = arr.length;
        int end = 0;
        
        for (int i = 0; i < n; i++) 
        {
            while (!stk.isEmpty() && stk.peek() == end + 1) 
            {
                stk.pop();
                end++;
            }
            
            if (stk.isEmpty() || arr[i] < stk.peek()) 
            {
                stk.push(arr[i]);
            } 
            else
            {
                return false;
            }
        }
        
        while (!stk.isEmpty() && stk.peek() == end + 1) 
        {
            stk.pop();
            end++;
        }
        
        return stk.isEmpty();
    }

    public static void main(String[] args) 
    {
        int[] arr1 = {4, 1, 2, 3};
        int[] arr2 = {4, 1, 3, 2};
        int[] arr3 = {2, 3, 1};
        int[] arr4 = {1, 3, 2};

        assert helper(arr1) == true;
        assert helper(arr2) == true;
        assert helper(arr3) == false;
        assert helper(arr4) == true;

        System.out.println("All test cases passed");
    }
}
