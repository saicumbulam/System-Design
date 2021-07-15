package DepthFirstSearch;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] > 0){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || grid[i][j] == -1){
            return 0;
        }
        int temp = grid[i][j];
        grid[i][j] = -1;// mark as visit

        int max = 0;
        max = Math.max(max, dfs(grid, i + 1, j));
        max = Math.max(max, dfs(grid, i - 1, j));
        max = Math.max(max, dfs(grid, i, j + 1));
        max = Math.max(max, dfs(grid, i, j - 1));

        grid[i][j] = temp;

        return temp + max;
    }
}
