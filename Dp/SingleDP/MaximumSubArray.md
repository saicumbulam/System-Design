package Dp.SingleDP;

public class MaximumSubArray {
    // take this sum or the maxSum
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum,curSum);
        }
        return maxSum;
    }
}
