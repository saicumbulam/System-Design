package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c, i);
        }

        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();

        for(int i= 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if (map.containsKey(c))
            {
                end = Math.max(end, map.get(c));
            }

            if (end == i)
            {
                result.add(end - start + 1);
                end++;
                start = end;
            }
        }

        return result;
    }
}
