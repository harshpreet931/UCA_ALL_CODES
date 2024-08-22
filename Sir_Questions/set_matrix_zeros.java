import java.util.*;

public class set_matrix_zeros {

    public static void main(String[] args) {
        int[][] temp1 = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] res1 = {{1,0,1},{0,0,0},{1,0,1}};

        int[][] temp2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] res2 = {{0,0,0,0},{0,4,5,0},{0,3,1,0}};

        helper(temp1);
        helper(temp2);

        assert Arrays.deepEquals(temp1, res1) : "Test Case 1 Failed";
        assert Arrays.deepEquals(temp2, res2) : "Test Case 2 Failed";

        System.out.println("All test cases passed!!");
    }


    private static void helper(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) firstRow = true;
                    if(j == 0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if(firstRow) {
            for(int i = 0; i < c; i++) matrix[0][i] = 0;
        }

        if(firstCol) {
            for(int i = 0; i < r; i++) matrix[i][0] = 0;
        }
    }
}