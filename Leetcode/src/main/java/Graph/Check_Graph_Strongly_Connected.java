package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Check_Graph_Strongly_Connected {
    static HashMap<Integer, List<Integer>> graph;
    static HashSet<Integer> visited = new HashSet<>();
    static boolean flag = false;

    public static void main(String[] args) {
        graph = new HashMap<>();
        graph.put(0, new ArrayList<>());
        graph.put(1, new ArrayList<>());
        graph.put(2, new ArrayList<>());
        graph.put(3, new ArrayList<>());
        graph.put(2, new ArrayList<>());
        graph.put(4, new ArrayList<>());
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(0);
        graph.get(2).add(4);
        graph.get(4).add(2);
        calc();
    }

    private static void calc() {
        dfs(0);
        visited = new HashSet<>();
        //take transpose and repeat the above step to determine its a stringly connected
        System.out.println(flag);
    }

    private static void dfs(int source) {
        System.out.println(source);
        if (visited.contains(source)) {
            flag = true;
            return;
        }
        visited.add(source);
        if (!graph.containsKey(source)) {
            System.out.println("im here");
            return;
        }

        for (int item : graph.get(source)) {
            dfs(item);
        }
    }
}