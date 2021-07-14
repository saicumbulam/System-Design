package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < t.length(); i++)
        {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int matched = 0;
        int  i = 0;

        for(int j = 0; j < s.length(); j++)
        {
            char c = s.charAt(j);
            if (map.containsKey(c))
            {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                {
                    matched++;
                }
            }

            if (matched == map.size())
            {
                result.add(i);
            }

            while(j - i + 1 >= t.length())
            {

                char left = s.charAt(i++);
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

        return result;
    }
}
