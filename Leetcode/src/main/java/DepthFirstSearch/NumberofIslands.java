package DepthFirstSearch;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i = 0; i< grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                    count += dfs(grid,i, j);
            }
        }
        return count;
    }

    private int dfs(char[][] grid, int r, int c)
    {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0')
        {
            return 0;
        }

        grid[r][c] = '0';

        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
        return 1;
    }
}
