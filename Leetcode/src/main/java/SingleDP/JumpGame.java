package SingleDP;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int minJumps = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (minJumps < i)
            {
                return false;
            }
            minJumps = Math.max(minJumps, nums[i] + i);
        }
        return true;
    }
}
