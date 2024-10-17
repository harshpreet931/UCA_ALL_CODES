package ritesh_sir_questions;

public class rotate_image {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        rotate_image obj = new rotate_image();
        obj.rotate(matrix);
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    private void swap(int[][] matrix, int i, int j, int k, int l) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }
    
    private void reverse(int[][] matrix, int i) {
        int start = 0, end = matrix[i].length - 1;
        while (start < end) {
            swap(matrix, i, start, i, end);
            start++;
            end--;
        }
    }
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i); // transpose
            }
        }
        
        for (int i = 0; i < n; i++) {
            reverse(matrix, i); // reverse ;)
        }
    }
}
