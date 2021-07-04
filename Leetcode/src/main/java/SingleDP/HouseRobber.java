package SingleDP;

public class HouseRobber {
    public int rob(int[] nums) {
        int prev = 0;
        int curr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(prev + nums[i], curr);
            prev = curr;
            curr = temp;
        }

        return curr;
    }
}
