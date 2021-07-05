package SubArraySumProblem;

import java.util.HashMap;

public class SubArraySumDivisibleByK {
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,1};
        int target = 3;
        System.out.println(Calculate(arr, target));
    }

    private static int Calculate(int[] arr, int k)
    {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            curSum %= k;
            if(curSum < 0) curSum += k; // Because -1 % 5 = -1,
            //but we need the positive mod 4

            if (map.containsKey(curSum))
            {
                count += map.get(curSum);
            }
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }


        return count;
    }
}
