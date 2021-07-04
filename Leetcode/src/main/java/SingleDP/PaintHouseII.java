package SingleDP;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        for (int i = 1; i < costs.length; i++) {
            int min = Integer.MAX_VALUE;
            int second_min = Integer.MAX_VALUE;
            for (int j = 0; j < costs[0].length; j++) {
                if (min == Integer.MAX_VALUE || costs[i-1][j] < min)
                {
                    second_min = min;
                    min =  costs[i-1][j];
                }
                else if (second_min == Integer.MAX_VALUE || costs[i-1][j] < second_min)
                {
                    second_min = costs[i-1][j];
                }
            }
            for (int j = 0; j < costs[0].length; j++) {
                if (costs[i-1][j] == min)
                {
                    costs[i][j] += second_min;
                }
                else
                {
                    costs[i][j] += min;
                }
            }

        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < costs[0].length; j++)
        {
            result = Math.min(result, costs[costs.length -1][j]);
        }
        return result;
    }
}
