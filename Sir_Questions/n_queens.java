import java.util.*;

public class n_queens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = solveNQueens(n);
        for (List<String> board : res) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    } 

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] arr = new char[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(arr[i], '.');

        helper(res, arr, 0);

        return res;
    }

    private static void helper(List<List<String>> res, char[][] arr, int row) {
        if(row == arr.length) {
            res.add(build(arr));
            return;
        }

        for(int col = 0; col < arr.length; col++) {
            if(isValid(arr, row, col)) {
                arr[row][col] = 'Q';
                helper(res, arr, row + 1);
                arr[row][col] = '.';
            }
        }
    }

    private static boolean isValid(char[][] arr, int row, int col) {
        for(int i = 0; i < row; i++) if(arr[i][col] == 'Q') return false;
        for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j--) if(arr[i][j] == 'Q') return false;
        for(int i = row-1, j = col+1; i>=0 && j<arr.length; i--, j++) if(arr[i][j] == 'Q') return false;
        return true;
    }

    private static List<String> build(char[][] arr) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) res.add(new String(arr[i]));
        return res;
    }
}
