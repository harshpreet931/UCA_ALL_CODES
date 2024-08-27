public class cherry_pickup {
    public static boolean isValid(int x, int y, int n, int m)
    {
        if(x < 0 || y < 0 || x >= n || y >= m)
        {
            return false;
        }
        return true;
    }
    
    public static int collect(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        return helper(grid, 0, 0, n, m);
    }

    // private static int helper(int[][] grid, int x, int y, int n, int m) 
    // {
    //     if (x >= n || y >= m) return 0;
    //     if (x == n - 1 && y == m - 1) return grid[x][y];

        
    //     int down = helper(grid, x + 1, y, n, m);
    //     int right = helper(grid, x, y + 1, n, m);

    //     return grid[x][y] + Math.min(down, right);
    // }

    private static int helper(int[][] grid, int x, int y, int n, int m)
    {
        if(x == n - 1 && y == m - 1)
        {
            return grid[x][y];
        }
        
        boolean choice1 = isValid(x + 1, y, n, m);
        boolean choice2 = isValid(x, y + 1, n, m);

        // we can take both paths
        if(choice1 && choice2)
        {
            int calcC1 = helper(grid, x + 1, y, n, m);
            int calcC2 = helper(grid, x, y + 1, n, m);
            return grid[x][y] + Math.min(calcC1, calcC2);
        }

        // we can only take one path
        if(choice1)
        {
            return grid[x][y] + helper(grid, x + 1, y, n, m);
        }
        return grid[x][y] + helper(grid, x, y + 1, n, m);
    }

    public static void main(String[] args) 
    {
        int[][] grid = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 1}
        };
        System.out.println(collect(grid));
    }
}
