package HashTable.FreqCounts;

import java.util.HashMap;

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
        {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character c: s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++)
        {
            if (map.get(s.charAt(i)) == 1)
            {
                return i;
            }
        }

        return -1;
    }
}
