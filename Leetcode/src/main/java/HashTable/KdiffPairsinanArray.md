package HashTable;

import java.util.HashMap;
import java.util.Map;

/*
A k-diff pair is an integer pair 
(nums[i], nums[j]), 
where the following are true:

0 <= i < j < nums.length
|nums[i] - nums[j]| == k
* */
public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {

        int result = 0;

        HashMap <Integer,Integer> counter = new HashMap<>();
        for (int n: nums) {
            counter.put(n, counter.getOrDefault(n, 0)+1);
        }
        
        for (Map.Entry <Integer, Integer> entry: counter.entrySet()) {
            int x = entry.getKey();
            int val = entry.getValue();
            if (k > 0 && counter.containsKey(x + k)) {
                result++;
            } else if (k == 0 && val > 1) {
                result++;
            }
        }
        return result;
    }
}
