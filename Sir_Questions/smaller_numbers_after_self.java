import java.util.*;

public class smaller_numbers_after_self {
    public static void main(String[] args) {
        int temp1[] = {5,2,6,1};
        int res1[] = {2,1,1,0};

        int temp2[] = {5,2,6,1,1};
        int res2[] = {3,1,3,0,0};

        int temp3[] = {-1};
        int res3[] = {0};

        int temp4[] = {-1,-1};
        int res4[] = {0, 0};

        assert Arrays.equals(countSmaller(temp1), res1) : "Test Case 1 Failed";
        assert Arrays.equals(countSmaller(temp2), res2) : "Test Case 2 Failed";
        assert Arrays.equals(countSmaller(temp3), res3) : "Test Case 3 Failed";
        assert Arrays.equals(countSmaller(temp4), res4) : "Test Case 4 Failed";

        System.out.println("All test cases passed!!");
    }

    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] indices = new int[n];
        int[][] aux = new int[2][n];
        for(int i = 0; i < n; i++) indices[i] = i;
        merge_sort(nums, indices, aux, count, 0, n-1);
        return count;
    }

    private static void merge_sort(int[] nums, int[] indices, int[][] aux, int[] count, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        merge_sort(nums, indices, aux, count, left, mid);
        merge_sort(nums, indices, aux, count, mid+1, right);
        merge(nums, indices, aux, count, left, mid, right);
    }    

    private static void merge(int[] nums, int[] indices, int[][] aux, int[] count, int left, int mid, int right) {
        for(int k = left; k <= right; k++) {
            aux[0][k] = nums[k];
            aux[1][k] = indices[k];
        }

        int i = left, j = mid+1;
        int rightCount = 0;
        for(int k = left; k <= right; k++) {
            if(i > mid) {
                nums[k] = aux[0][j];
                indices[k] = aux[1][j++];
            }   
            else if(j > right) {
                nums[k] = aux[0][i];
                indices[k] = aux[1][i];
                count[aux[1][i]] += rightCount;
                i++;
            }
            else if(aux[0][i] > aux[0][j]) {
                nums[k] = aux[0][j];
                indices[k] = aux[1][j];
                rightCount++;
                j++;
            }
            else {
                nums[k] = aux[0][i];
                indices[k] = aux[1][i];
                count[aux[1][i]] += rightCount;
                i++;
            }
        }
    }
}
