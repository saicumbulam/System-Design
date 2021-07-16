package Recursion;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++)
        {
            map.put(s.charAt(i),
                    map.getOrDefault(s.charAt(i),
                            0) + 1);
        }

        boolean flag = true;

        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if(entry.getValue() < k)
            {
                flag = false;
                break;
            }
        }

        if(flag)
        {
            return s.length();
        }

        int curr = 0;
        int start = 0;

        while(curr < s.length())
        {
            if(map.get(s.charAt(curr)) < k)
            {
                maxLength = Math.max(maxLength,
                        longestSubstring(s.substring(start, curr), k));
                start = curr+1;
            }
            curr++;
        }

        maxLength = Math.max(maxLength,
                longestSubstring(s.substring(start), k));

        return maxLength;
    }
}
