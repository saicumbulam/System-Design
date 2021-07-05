package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class DjiktrasAlgorithm {
    static HashMap<Integer, HashMap<Integer,Integer>> graph;
    static HashSet<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        graph = new HashMap<>();
        graph.put(0, new HashMap<>());
        graph.put(1, new HashMap<>());
        graph.put(2, new HashMap<>());
        graph.get(0).put(1, 10);
        graph.get(1).put(2, 6);
        graph.get(0).put(2, 500);
        calc(0, 2);
    }

    private static void calc(int src, int dest) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        minHeap.add(new int[]{0, src});
        HashMap<Integer, Integer> visited = new HashMap<>();

        while(!minHeap.isEmpty())
        {
            int[] polled = minHeap.poll();
            int d = polled[0];
            int node = polled[1];

            if(visited.containsKey(node)) continue;
            visited.put(node, d);

            if (graph.containsKey(node))
            {
                for(Map.Entry<Integer, Integer> entry: graph.get(node).entrySet())
                {
                    if (!visited.containsKey(entry.getKey()))
                    {
                        minHeap.add(new int[]{d + entry.getValue(), entry.getKey()});
                    }
                }
            }
        }

        System.out.println(visited.get(dest));
    }


}
