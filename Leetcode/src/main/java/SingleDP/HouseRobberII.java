package SingleDP;

public class HouseRobberII {
    // if the thief steals the first house, he cannot steal the last house.
    // Thus we have two arrays to calculate the sum
    public int rob(int[] nums) {
        return Math.max(calculate(nums, 0, nums.length-2),
                calculate(nums, 1, nums.length-1));
    }

    public int calculate(int[] nums, int start, int end) {
        int prev = 0;
        int curr = nums[start];

        for (int i = start; i<= end; i++)
        {
            int temp = Math.max(prev + nums[i], curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
