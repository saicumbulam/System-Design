package Dp.SingleDP;

//TODO: Study
// similar to house robber
public class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        int max= 0;
        for(int num: nums)
        {
            max = Math.max(max, num);
        }

        int[] values = new int[max+1];
        for (int num : nums) {
            values[num] += num;
        }
        int curr = 0, prev = 0;
        for (int value : values)
        {
            int next = Math.max(prev + value, curr);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
