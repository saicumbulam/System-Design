package TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int smallest = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++)
        {
            int left = i+1;
            int right = nums.length-1;

            while(left < right)
            {
                int diff = target - (nums[i] + nums[left] + nums[right]);
                if(diff == 0)
                {
                    return nums[i] + nums[left] + nums[right];
                }

                if ((Math.abs(smallest) > Math.abs(diff))  ||
                        Math.abs(smallest) == Math.abs(diff) && smallest > diff)
                {
                    smallest = diff;
                }

                if(diff > 0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }

        return target - smallest;
    }
}
