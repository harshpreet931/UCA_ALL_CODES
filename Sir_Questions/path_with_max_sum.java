public class path_with_max_sum {
    // Problem: Find the Path with Maximum Value in a Grid
    // Given a 2D grid where each cell contains a value, you need to find the path from the top-left to the bottom-right corner that maximizes the sum of values. You can move either right or down.
    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        assert find_max_value_path(grid) == 29 : "Test Case 1 Failed";

        int[][] grid2 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        assert find_max_value_path(grid2) == 12 : "Test Case 2 Failed";

        System.out.println("All test cases passed!!"); 
    }

    public static int find_max_value_path(int[][] grid) {
        return helper(grid, 0, 0);
    }

    public static int helper(int[][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[0].length) return Integer.MIN_VALUE;
        if(i == grid.length-1 && j == grid[0].length-1) return grid[i][j];

        int right = helper(grid, i, j+1);
        int down = helper(grid, i+1, j);

        return grid[i][j] + Math.max(right, down);
    }
}
