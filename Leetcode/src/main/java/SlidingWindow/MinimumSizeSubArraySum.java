package SlidingWindow;

//TODO: Dont Remember
public class MinimumSizeSubArraySum {
    int minLength = Integer.MAX_VALUE;

    public int minSubArrayLen(int target, int[] nums) {
        Calculate(nums, target);
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    private void Calculate(int[] nums, int target)
    {
        int sum = 0;
        int i = 0;

        for(int j = 0; j < nums.length; j++)
        {
            sum += nums[j];

            while(sum >= target)
            {
                minLength = Math.min(minLength, j - i + 1);
                System.out.println("Before: " + sum);
                sum -= nums[i++];
                System.out.println("After: " + sum);
            }
        }
    }
}
