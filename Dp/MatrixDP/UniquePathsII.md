package Dp.MatrixDP;

import java.util.Arrays;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        for (int i = 1; i < obstacleGrid.length; i++)
        {
            if(obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1)
            {
                obstacleGrid[i][0] = 1;
            }
            else {
                obstacleGrid[i][0] = 0;
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i++)
        {
            if(obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1)
            {
                obstacleGrid[0][i] = 1;
            }
            else {
                obstacleGrid[0][i] = 0;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++)
        {
            for (int j = 1; j < obstacleGrid[0].length; j++)
            {
                if(obstacleGrid[i][j] == 0)
                {
                    obstacleGrid[i][j] += obstacleGrid[i-1][j] +
                            obstacleGrid[i][j-1] ;
                }
                else if(obstacleGrid[i][j] == 1)
                {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
