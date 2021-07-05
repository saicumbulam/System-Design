package Graph;

import java.util.HashMap;
import java.util.List;

public class Graph {
    HashMap<Integer, List<Integer>> graph;

    public Graph(int vertices)
    {
        graph = new HashMap<Integer, List<Integer>>();
    }

    public void addEdge(int source, int destination)
    {
        graph.get(source).add(destination);
    }
}
