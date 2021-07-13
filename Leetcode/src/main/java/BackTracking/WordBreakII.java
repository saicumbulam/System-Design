package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringJoiner;

//O(N^2+ 2^N + W) | O(2^N * N + W)
public class WordBreakII {
    List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict)
    {
        HashSet<String> set = new HashSet<>(wordDict);
        calc(s, set, 0, new ArrayList<>());
        return result;
    }

    private void calc(String s, HashSet<String>  wordDict,
                         int index, List<String> curr)
    {
        if(index >= s.length())
        {
            StringJoiner joiner = new StringJoiner(" ");
            for (String item: curr) joiner.add(item);
            result.add(joiner.toString());
        }

        for (int i = index; i <= s.length(); i++) {
            String tmp = s.substring(index, i);
            if (wordDict.contains(tmp)) {
                curr.add(tmp);
                calc(s, wordDict, i, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
