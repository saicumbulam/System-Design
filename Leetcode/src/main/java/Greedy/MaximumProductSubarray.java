package Greedy;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int maxProduct = nums[0];
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(nums[i], Math.max(temp * nums[i],
                    curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(temp * nums[i],
                    curMin * nums[i]));
            maxProduct = Math.max(maxProduct, curMax);
        }
        return maxProduct;
    }
}
