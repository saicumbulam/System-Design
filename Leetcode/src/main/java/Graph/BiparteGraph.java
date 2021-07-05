package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BiparteGraph {
    static HashMap<Integer, List<Integer>> graph;
    static HashMap<Integer, Integer> color = new HashMap<>();

    public static void main(String[] args) {
        graph = new HashMap<>();
        graph.put(0, new ArrayList<>());
        graph.put(1, new ArrayList<>());
        graph.put(2, new ArrayList<>());
        graph.put(3, new ArrayList<>());
        graph.put(4, new ArrayList<>());
        graph.put(5, new ArrayList<>());
        graph.put(6, new ArrayList<>());
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(4).add(5);
        graph.get(5).add(0);
        System.out.println(calc());
    }

    private static boolean calc() {
        for (int i = 0; i <= 6; i++) {
            if (!color.containsKey(i)) {
                color.put(i, 1);
            }

            for (int edge : graph.get(i)) {
                if (!color.containsKey(edge)) {
                    int temp = color.get(i);
                    color.put(edge, -1 * temp);
                } else if (color.get(edge).equals(color.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}