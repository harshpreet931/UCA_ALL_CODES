public class single_number_ii 
{
    public static void main(String[] args) 
    {
        int[] arr = {2, 2, 3, 2};
        assert singleNumber(arr) == 3 : "Test case 1 failed";
        System.out.println("Test case 1 passed!");

        int[] arr2 = {0, 1, 0, 1, 0, 1, 99};
        assert singleNumber(arr2) == 99 : "Test case 2 failed";
        System.out.println("Test case 2 passed!");
    }

    private static int singleNumber(int[] nums) 
    {
        int ans = 0;
        for(int i = 0; i < 32; i++)
        {
            int sum = 0;
            for(int j = 0; j < nums.length; j++)
            {
                if(((nums[j] >> i) & 1 )== 1) sum++;
            }
            sum %= 3;
            if(sum != 0) ans |= sum << i;
        }
        return ans;
    }
}
