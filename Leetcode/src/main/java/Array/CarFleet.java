package Array;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.
* */
public class CarFleet {
    public static int carFleet(int target, int[] pos, int[] speed)
    {
        Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < pos.length; ++i)
        {
            m.put(pos[i], (double)(target - pos[i]) / speed[i]);
        }

        int res = 0; double cur = 0;
        for (double time : m.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3});
    }
}
