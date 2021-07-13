package BreadthFirstSearch;

import java.util.*;

//O(M^2 × N) | O(M^2 × N)
// M is length of longest word and N is the number of words
public class WordLadder {
    class Pair
    {
        String value;
        int numValue;

        public Pair(String value, int numValue) {
            this.value = value;
            this.numValue = numValue;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word: wordList)
        {
            for (int i = 0; i < word.length(); i++)
            {
                String newWord = word.substring(0,i) + '*' + word.substring(i+1);
                if (!map.containsKey(newWord))
                {
                    map.put(newWord, new ArrayList<>());
                }
                map.get(newWord).add(word);
            }
        }


        Queue<Pair> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        queue.add(new Pair(beginWord, 1));
        set.contains(beginWord);

        while(!queue.isEmpty())
        {
            Pair polled = queue.poll();
            String word = polled.value;
            int level = polled.numValue;

            for(int i = 0; i < beginWord.length(); i++)
            {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1);

                if (!map.containsKey(newWord)) continue;
                for(String item : map.get(newWord))
                {
                    if (item.equals(endWord))
                    {
                        return level+1;
                    }

                    if (!set.contains(item))
                    {
                        set.add(item);
                        queue.add(new Pair(item, level+1));
                    }
                }
            }
        }

        return 0;
    }
}
