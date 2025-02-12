import java.util.Scanner;

public class MatrixProgs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] transpose(int[][] matrix)
    {
        int n = matrix.length, m = matrix[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                res[j][i] = matrix[i][j];
        return res;
    }
    private static int[][] rotate90clockwise(int[][] matrix) {
        // Transpose the matrix then reverse the rows
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < matrix.length; i++)
        {
            int start = 0, end = matrix[i].length - 1;
            while(start < end)
            {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
        return matrix;
    }

    private static int[][] multiply(int[][] a, int[][] b)
    {
        int rows = a.length, cols = b[0].length, n = b.length;
        int[][] res = new int[rows][cols];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                for(int k = 0; k < n; k++)
                    res[i][j] += a[i][k] * b[k][j];
        return res;
    }

    private static int diagonalSum(int[][] matrix)
    {
        int n = matrix.length, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += matrix[i][i];
            if(i != n - i - 1)
                sum += matrix[i][n - i - 1];
        }
        return sum;
    }
}
