package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n⋅2^n) | o(n)
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for(int i = 0; i < nums.length; i++)
        {
            start = 0;

            if (i > 0 && nums[i] == nums[i-1])
            {
                start = end + 1;
            }

            end = result.size()-1;

            for(int j = start; j <= end; j++)
            {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }

        return result;
    }
}
