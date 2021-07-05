package SubArraySumProblem;

import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {
        int[] arr = {1,-20,-3,30,5,4};
        int target = 7;
        int[] result = Calculate(arr, target);
        for (int item: result) {
            System.out.println(item);
        }
    }

    private static int[] Calculate(int[] arr, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int curSum = 0;

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];

            if (map.containsKey(curSum - target))
            {
                return new int[]{map.get(curSum - target), i + 1}; // right is exclusive
            }
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return new int[]{-1, -1};
    }
}
