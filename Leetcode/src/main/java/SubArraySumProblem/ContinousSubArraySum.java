package SubArraySumProblem;

import java.util.HashMap;

public class ContinousSubArraySum {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(Calculate(nums, k));
    }

    private static boolean Calculate(int[] arr, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        map.put(0, 1); // sum of 0 will be encountered

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            if(target != 0) curSum %= target;

            if (map.containsKey(curSum))
            {
                if (i - map.get(curSum) > 1 )
                {
                    return true;
                }
            }
            map.put(curSum, i);
        }

        return false;
    }
}
