package Dp.knapsack;

//TODO: Study
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }

        if(sum %2 != 0) return false;
        sum = sum/2;

        boolean[][] dp = new boolean[nums.length][sum + 1];

        for(int i = 0; i < nums.length; i++)
        {
            dp[i][0] = true;
        }

        for(int s = 1; s <= sum; s++)
        {
            dp[0][s] = nums[0] == s;
        }


        for(int i = 1; i < nums.length; i++)
        {
            for(int s = 1; s <= sum; s++)
            {
                if(dp[i-1][s])
                {
                    dp[i][s] = dp[i-1][s];
                }
                else if(s >= nums[i])
                {
                    dp[i][s] = dp[i-1][s - nums[i]];
                }
            }
        }

        return dp[nums.length-1][sum];
    }
}
