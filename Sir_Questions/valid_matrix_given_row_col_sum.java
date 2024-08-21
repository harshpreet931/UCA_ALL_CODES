import java.util.*;

public class valid_matrix_given_row_col_sum 
{
    private static int[][] restoreMatrix(int[] rowSum, int[] colSum)  
    {
        int n = rowSum.length, m = colSum.length;
        int[][] res = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
            }
        }

        return res;
    }    

    public static void main(String[] args) 
    {
        int[] temp1 = {3, 8};
        int[] temp2 = {4, 7};
        int[][] res1 = restoreMatrix(temp1, temp2);

        assert res1[0][0] == 3 && res1[0][1] == 0 && res1[1][0] == 1 && res1[1][1] == 7 : "Test Case 1 Failed";
        System.out.println("All test cases passed!");
    }
}
