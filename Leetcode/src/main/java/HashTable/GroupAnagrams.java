package HashTable;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs)
        {
            char[] strarr = str.toCharArray();
            int[] arr = new int[26];
            for(char c: strarr)
            {
                arr[c - 'a'] += 1;
            }

            StringBuilder key = new StringBuilder();
            for(int i = 0; i < 26; i++)
            {
                key.append(String.valueOf(arr[i])).append("#");
            }

            if(!map.containsKey(key.toString()))
            {
                map.put(key.toString(), new ArrayList<>());
            }
            map.get(key.toString()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
