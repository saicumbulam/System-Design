package Graph;

import java.util.*;

public class AlienDictionary {    public String alienOrder(String[] words) {
    HashMap<Character, List<Character>> graph = new HashMap<>();
    HashMap<Character, Integer> inDegree = new HashMap<>();
    StringBuilder str = new StringBuilder();

    for (int i = 0; i < words.length; i++)
    {
        for (char c: words[i].toCharArray())
        {
            graph.putIfAbsent(c, new ArrayList<>());
            inDegree.putIfAbsent(c , 0);
        }
    }

    for (int i = 1; i < words.length; i++)
    {
        String w1 = words[i-1];
        String w2 = words[i];

        // Check that word2 is not a prefix of word1.

        if (w1.length() > w2.length() && w1.startsWith(w2)) {
            return "";
        }

        for (int j = 0; j < Math.min(w1.length(), w2.length()); j++)
        {
            char parent = w1.charAt(j);
            char child = w2.charAt(j);

            if (parent != child)
            {
                graph.get(parent).add(child);
                inDegree.put(child , inDegree.get(child)+1);
                break;
            }
        }
    }

    Queue<Character> sources = new LinkedList<>();
    for (Map.Entry<Character, Integer> entry : inDegree.entrySet())
    {
        if (entry.getValue() == 0)
        {
            sources.add(entry.getKey());
        }

    }


    while (!sources.isEmpty())
    {
        char vertex = sources.poll();
        str.append(vertex);

        List<Character> children = graph.get(vertex);
        for(char child: children)
        {
            inDegree.put(child, inDegree.get(child)-1);
            if (inDegree.get(child) == 0)
            {
                sources.add(child);
            }
        }
    }

    if (str.length() < inDegree.size()) return "";

    return str.toString();
}

}
