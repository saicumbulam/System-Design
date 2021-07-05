package Dp;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr) {
        int count = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int item: arr) {
            set.add(item);
        }

        for (int i = 0; i < arr.length; i++) {
            if(!set.contains(arr[i] -1))
            {
                int item = arr[i];
                int count_tmp = 0;
                while (set.contains(item))
                {
                    item++;
                    count_tmp++;
                }
                count = Math.max(count, count_tmp);
            }
        }
        return count;
    }


}
