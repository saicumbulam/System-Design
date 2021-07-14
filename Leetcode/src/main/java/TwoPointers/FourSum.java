package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//o(n^3) | o(n)
public class FourSum {
    List<List<Integer>> result;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length-3; i++)
        {
            if (i > 0 && nums[i] == nums[i-1])
            {
                continue;
            }

            for (int j = i+1; j < nums.length-2; j++)
            {
                if (j > i+1 && nums[j] == nums[j-1])
                {
                    continue;
                }

                twoSum(nums, target, i, j);
            }
        }

        return result;
    }

    public void twoSum(int[] nums, int target, int first, int second)
    {
        int left = second + 1;
        int right = nums.length - 1;

        while (left < right)
        {
            int currentSum = nums[left] +
                    nums[right] + nums[first] + nums[second];
            if( currentSum == target )
            {
                result.add(Arrays.asList(nums[left],nums[right],
                        nums[first], nums[second]));
                left++;
                right--;

                while (left < right && nums[left] == nums[left-1])
                {
                    left++;
                }

                while (left < right && nums[right] == nums[right+1])
                {
                    right--;
                }
            }
            else if ( currentSum < target )
            {
                left++;
            }
            else
            {
                right--;
            }
        }
    }
}
