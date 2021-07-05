package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Count_Paths_Two_Nodes {
    static HashMap<Integer, List<Integer>> graph;
    static HashMap<Integer, List<Integer>> clone;
    static HashSet<Integer> visited = new HashSet<>();
    static int count = 0;

    public static void main(String[] args) {
        graph = new HashMap<>();
        clone = new HashMap<>();
        graph.put(0, new ArrayList<>());
        graph.put(1, new ArrayList<>());
        graph.put(2, new ArrayList<>());
        graph.put(5, new ArrayList<>());
        graph.put(3, new ArrayList<>());
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(1).add(5);
        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(5).add(3);
        graph.get(5).add(6);
        graph.get(3).add(6);
        calc(0, 6);
    }

    private static void calc(int source, int destination) {
        dfs(source, destination);
        System.out.println(count);
    }

    private static void dfs(int source, int destination) {
        if (source == destination) {
            count++;
            return;
        }
        if (!graph.containsKey(source)) return;

        for (int item : graph.get(source)) {
            if (!visited.contains(item)) {
                dfs(item, destination);
            }
        }
    }
}