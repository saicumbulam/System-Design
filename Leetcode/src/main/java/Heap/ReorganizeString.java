package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: S.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty())
        {
            Map.Entry<Character, Integer> polled = maxHeap.poll();
            result.append(polled.getKey());
            if (previousEntry != null && previousEntry.getValue() > 0)
            {
                maxHeap.add(previousEntry);
            }
            polled.setValue(polled.getValue() - 1);
            previousEntry = polled;
        }

        return result.length() == S.length() ? result.toString(): "";
    }
}
