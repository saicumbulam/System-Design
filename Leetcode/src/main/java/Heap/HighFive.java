package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int[] item: items)
        {
            if(map.containsKey(item[0]))
            {
                PriorityQueue<Integer> minHeap = map.get(item[0]);
                minHeap.add(item[1]);
                if(minHeap.size() > 5)
                {
                    minHeap.poll();
                }
                map.put(item[0], minHeap);
            }
            else
            {
                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                minHeap.add(item[1]);
                map.put(item[0], minHeap);
            }
        }

        int[][] arr = new int[map.size()][2];
        int index = 0;

        for(Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet())
        {
            arr[index][0] = entry.getKey();
            PriorityQueue<Integer> pq = entry.getValue();
            int sum = 0;
            int size = pq.size();
            while(!pq.isEmpty())
            {
                sum += pq.poll();
            }
            arr[index][1] = sum/size;
            index++;
        }

        return arr;
    }
}
