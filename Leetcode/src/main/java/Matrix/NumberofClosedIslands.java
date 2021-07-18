package Matrix;

public class NumberofClosedIslands {
    public int closedIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j)) res++;
                }
            }
        }

        return res;
    }

    public boolean dfs(int[][] grid, int x, int y){

        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;

        if(grid[x][y] == 1) return true;

        grid[x][y] = 1;

        boolean down = dfs(grid, x+1,y);
        boolean up = dfs(grid, x-1,y);
        boolean right = dfs(grid, x,y+1);
        boolean left = dfs(grid, x,y-1);

        return up & down & left & right;
    }
}
