package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++)
        {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++)
        {
            if (map.containsKey(nums2[i]))
            {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                list.add(nums2[i]);
                if (map.get(nums2[i]) == 0)
                {
                    map.remove(nums2[i]);
                }
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }
}
