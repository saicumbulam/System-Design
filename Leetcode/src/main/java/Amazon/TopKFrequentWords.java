package Amazon;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        int k = 2;
        String[] keywords = new String[]{"gatsby", "american", "novel"};

        String[] snippets = new String[]{
                "The opening of The Great Gatsby -- its first 3-4 pages -- ranks among the best of any novel in the English language.",
                "It is masterful, some may say the great American novel.",
                "The Great Gatsby is a 1925 novel written by American author F. Scott Fitzgerald"};

        System.out.println(Calculate(k, keywords, snippets));
    }

    private static List<String> Calculate(int k, String[] keyWords, String[] snippets)
    {
        HashMap<String, Integer> map = new HashMap<>();

        for(String str: snippets)
        {
            String[] split = str.split(" ");
            for (int i = 0; i < split.length; i++) {
                String word = split[i];
                StringBuilder sb = new StringBuilder();
                for(char c: word.toCharArray())
                {
                    if (Character.isLetter(c))
                    {
                        if (Character.isUpperCase(c))
                        {
                            sb.append(Character.toLowerCase(c));
                        }
                        else
                        {
                            sb.append(c);
                        }

                    }
                }
                word = sb.toString();
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(new wordComparator());
        maxHeap.addAll(map.entrySet());
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String word: keyWords)
            set.add(word);

        while (!maxHeap.isEmpty() && k > 0)
        {
            String word = maxHeap.poll().getKey();
            if (set.contains(word))
            {
                result.add(word);
                k--;
            }
        }
        return result;
    }

    static class wordComparator implements Comparator<Map.Entry<String, Integer>>{

        // Overriding compare()method of Comparator
        // for descending order of cgpa
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            if (a.getValue() == b.getValue())
            {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        }
    }
}
