package SubArraySumProblem;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(Calculate(nums, k));
    }

    private static int Calculate(int[] arr, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        int count = 0;
        map.put(0, 1); // sum of 0 will be encountered

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];

            if (map.containsKey(curSum - target))
            {
                count += map.get(curSum - target); // right is exclusive
            }
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return count;
    }
}
