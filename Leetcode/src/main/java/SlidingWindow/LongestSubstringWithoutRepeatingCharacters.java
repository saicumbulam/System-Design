package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    //start will be Math.max because "abba" test will not pass
    // when encountering a again, map.get(end)+1 will not take
    // you to a, it stays at the b only.
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int maxLength = 0;

        for(int j = 0; j < s.length(); j++)
        {
            char right = s.charAt(j);

            if (map.containsKey(right))
            {
                System.out.println("before:" + i + "," + j);
                i = Math.max(i,map.get(right)+1);
                System.out.println("after:" + map.get(right));
            }

            map.put(right, j);
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}
