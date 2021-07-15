package Greedy;

import java.util.Map;
import java.util.TreeMap;

public class DivideArrayinSetsofKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> count = new TreeMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() != 0)
            {
                int freq = entry.getValue();

                for (int i = 0; i < k; i++) {
                    if (!count.containsKey(entry.getKey() + i) ||
                            count.get(entry.getKey() + i) < freq)
                    {
                        return false;
                    }
                    count.put(entry.getKey() + i,
                            count.get(entry.getKey() + i) - freq);
                }
            }
        }

        return true;
    }
}
