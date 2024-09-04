import java.util.*;

public class maximal_rectange {
    public static void main(String[] args) {
        maximal_rectange obj = new maximal_rectange();
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        assert obj.maximalRect(matrix) == 6;
        System.out.println("All test cases passed!");
    }

    public int maximalRect(char[][] matrix) {
        int[] row = new int[matrix[0].length];
        int area = 0;
        Arrays.fill(row, 0);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') row[j]++;
                else row[j] = 0;
            }
            area = Math.max(area, largestRectangleArea(row));
        }
        return area;
    }
    private int largestRectangleArea(int[] row) {
        Stack<Integer> s = new Stack<>();
        int m = 0, i = 0;
        while(i <= row.length) {
            int val = i < row.length ? row[i] : 0;
            if(s.isEmpty() || val >= row[s.peek()]) s.push(i++);
            else {
                int h = row[s.pop()];
                int w = s.isEmpty() ? i : i - s.peek() - 1;
                m = Math.max(m, h * w);
            }
        }
        return m;
    }
}
