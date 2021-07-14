package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int maxLength = 0;

        for(int j = 0; j < s.length(); j++)
        {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k)
            {
                char leftChar = s.charAt(i++);
                if (map.containsKey(leftChar))
                {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0)
                    {
                        map.remove(leftChar);
                    }
                }
            }

            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}
