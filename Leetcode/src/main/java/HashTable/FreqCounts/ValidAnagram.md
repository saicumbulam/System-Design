package HashTable.FreqCounts;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character item : s.toCharArray())
        {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        for (Character item : t.toCharArray())
        {
            if (!map.containsKey(item))
            {
                return false;
            }
            else
            {
                map.put(item, map.get(item) - 1);
                if (map.get(item) == 0)
                {
                    map.remove(item);
                }
            }
        }

        if (map.size() == 0)
        {
            return true;
        }
        return false;
    }
}
