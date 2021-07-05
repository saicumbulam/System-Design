package Graph;

import java.util.*;

//level starts from zero
public class Number_Nodes_Graph_Level {
    static HashMap<Integer, List<Integer>> graph;
    static HashSet<Integer> visited = new HashSet<>();

    static class Vertex
    {
        int val;
        int level;

        public Vertex(int val, int level)
        {
            this.level = level;
            this.val = val;
        }
    }
    private static void calc(int k)
    {
        int level = 0;
        List<Integer> result = new ArrayList<>();

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(0, 0));

        while(!queue.isEmpty()) {
            Vertex vertex = queue.poll();

            if (vertex.level == k) {
                result.add(vertex.val);
            }

            if (!graph.containsKey(vertex.val)) continue;
            for(int item: graph.get(vertex.val))
            {
                if (!visited.contains(item))
                {
                    queue.add(new Vertex(item, vertex.level + 1));
                }
            }
        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        graph = new HashMap<>();
        graph.put(0, new ArrayList<>());
        graph.put(1, new ArrayList<>());
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);
        calc(2);
    }
}