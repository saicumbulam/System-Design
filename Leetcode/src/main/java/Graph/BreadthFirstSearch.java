package Graph;

import java.util.*;

public class BreadthFirstSearch {

    static List<Integer> result = new ArrayList<>();
    static HashSet<Integer> visited = new HashSet<>();
    static HashMap<Integer, List<Integer>> graph;

    private static void bfsMain(HashMap<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty())
        {
            int vertex = queue.poll();
            result.add(vertex);
            if (!graph.containsKey(vertex)) continue;

            for(int edge : graph.get(vertex))
            {
                if(visited.contains(edge)) continue;
                queue.add(edge);
                visited.add(edge);
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
        bfsMain(graph);
    }
}
