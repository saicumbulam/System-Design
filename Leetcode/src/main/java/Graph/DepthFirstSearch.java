package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DepthFirstSearch {
    static List<Integer> result = new ArrayList<>();
    static HashSet<Integer> visited = new HashSet<>();
    static HashMap<Integer, List<Integer>> graph;

    private static void bfsMain(HashMap<Integer, List<Integer>> graph) {
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int source) {
        visited.add(source);
        result.add(source);

        if (!graph.containsKey(source)) return;
        for(int item: graph.get(source)) {
            if(!visited.contains(item))
            {
                dfs(item);
            }
        }
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