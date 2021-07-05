package Graph;

import java.util.*;

public class TransposeGraph {
    static HashMap<Integer, List<Integer>> graph;
    static HashMap<Integer, List<Integer>> clone;
    static HashSet<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        graph = new HashMap<>();
        clone = new HashMap<>();
        graph.put(0, new ArrayList<>());
        graph.put(1, new ArrayList<>());
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);
        calc();
    }

    private static void calc() {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            for (int nei : entry.getValue()) {
                if (!clone.containsKey(nei)) {
                    clone.put(nei, new ArrayList<>());
                }
                clone.get(nei).add(entry.getKey());
            }
        }
        System.out.println(clone);
    }
}