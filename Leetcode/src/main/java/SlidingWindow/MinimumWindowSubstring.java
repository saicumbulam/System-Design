package SlidingWindow;

import java.util.HashMap;

/*
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation:
The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
* */
//o(s+t)| o(s+t)
public class MinimumWindowSubstring {
    public String minWindow(String str, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < t.length(); i++)
        {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int matched = 0;
        int substrStart = 0;
        int minLength = str.length()+1;
        int i = 0;
        char[] arr = str.toCharArray();

        for(int j = 0; j < arr.length; j++)
        {
            char right = arr[j];
            if (map.containsKey(right))
            {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0)
                {
                    matched++;
                }
            }

            while(matched == map.size())
            {
                if (minLength > (j - i + 1))
                {
                    minLength = j-i+1;
                    substrStart = i;
                }
                char left = arr[i++];
                if (map.containsKey(left))
                {
                    if (map.get(left) == 0)
                    {
                        matched--;
                    }
                    map.put(left, map.get(left) + 1);
                }
            }
        }

        return minLength > str.length() ? "" :
                str.substring(substrStart, substrStart + minLength);
    }
}
