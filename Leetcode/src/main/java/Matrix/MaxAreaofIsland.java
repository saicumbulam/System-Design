package Matrix;

public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1)
                {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int r, int c)
    {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                || grid[r][c] == 0)
        {
            return 0;
        }

        int count = 1;
        grid[r][c] = 0;
        count += dfs(grid, r+1, c);
        count += dfs(grid, r-1, c);
        count += dfs(grid, r, c+1);
        count += dfs(grid, r, c-1);
        return count;
    }
}
