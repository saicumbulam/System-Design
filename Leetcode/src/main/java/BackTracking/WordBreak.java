package BackTracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict)
    {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<Integer, Boolean> map = new HashMap<>();
        return calc(s, set, 0, map);
    }

    private boolean calc(String s, HashSet<String>  wordDict,
                         int index, HashMap<Integer, Boolean> map)
    {
        if(map.containsKey(index)) return map.get(index);

        if(index >= s.length())
        {
            map.put(index, true);
            return true;
        }

        for (int i = index; i <= s.length(); i++) {
            String tmp = s.substring(index, i);
            if(wordDict.contains(tmp))
            {
                if(calc(s, wordDict, i, map))
                {
                    map.put(index, true);
                    return true;
                }
            }
        }
        map.put(index, false);
        return false;
    }
}
