package google;

import java.util.LinkedList;
import java.util.Queue;

public class out_boundry_paths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int level = 0;
        int result = 0;
        int[][] dirs = {{0,1}, {1,0}, {-1, 0}, {-1, 0}};
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                int[] polled = queue.poll();
                int x = polled[0];
                int y = polled[1];

                for (int[] dir: dirs) {
                    int new_x = x + dir[0];
                    int new_y = y + dir[1];

                    if(new_x < 0 || new_x >= m || new_y < 0 || new_y >= n)
                    {
                       result++;
                    }
                    else
                    {
                        queue.add(new int[]{new_x, new_y});
                    }
                }
            }
            level++;
            if (level == maxMove) return result;
        }
        return result;
    }
}
