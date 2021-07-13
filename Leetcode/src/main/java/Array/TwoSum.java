package Array;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int sum = 0;
        if(nums.length == 0) return new int[] {-1};
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int value = target - nums[i];

            if (map.containsKey(value))
            {
                return new int[] {map.get(value), i};
            }
            map.put(nums[i], i);
        }

        return new int[] {-1};
    }
}
