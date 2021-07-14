package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(String word: words)
        {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int num_words = words.length;
        int word_length = words[0].length();

        for(int i = 0; i <= s.length() - (num_words * word_length); i++)
        {
            HashMap<String, Integer> curr = new HashMap<>();
            for(int j = 0; j < num_words; j++)
            {
                int next_index = i + j*word_length;
                String temp = s.substring(next_index, next_index + word_length);

                if (!map.containsKey(temp))
                {
                    break;
                }
                curr.put(temp, curr.getOrDefault(temp, 0) + 1);

                if (map.get(temp) < curr.get(temp))
                {
                    break;
                }

                if (j + 1 == num_words)
                {
                    result.add(i);
                }
            }
        }

        return result;
    }

}
