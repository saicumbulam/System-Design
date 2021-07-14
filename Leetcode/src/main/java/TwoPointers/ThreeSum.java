package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//o(n^2) | o(n)
public class ThreeSum {
    List<List<Integer>> result;

    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++)
        {
            if (i > 0 && nums[i] == nums[i-1])
            {
                continue;
            }
            searchPair(nums, i, i+1);
        }

        return result;
    }

    public void searchPair(int[] nums, int i, int left)
    {
        int right = nums.length-1;

        while (left < right)
        {
            int currentSum = nums[i] + nums[left] + nums[right];
            if (currentSum  == 0)
            {
                result.add(Arrays.asList(nums[left],
                        nums[right], nums[i]));
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
            else if (0 > currentSum)
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
