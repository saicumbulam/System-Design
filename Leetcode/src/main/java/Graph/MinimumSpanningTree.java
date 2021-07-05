package Graph;

import java.util.HashMap;
import java.util.HashSet;

//prims algorithm
// time complexity o(EV), space: o(n)
public class MinimumSpanningTree {
    static HashMap<Integer, HashMap<Integer,Integer>> graph;
    static HashSet<Integer> visited = new HashSet<>();
    static int V  = 4;

    public static void main(String[] args) {
        graph = new HashMap<>();
        graph.put(0, new HashMap<>());
        graph.put(1, new HashMap<>());
        graph.put(2, new HashMap<>());
        graph.put(3, new HashMap<>());
        graph.get(0).put(1, 10);
        graph.get(0).put(2, 6);
        graph.get(0).put(3, 5);
        graph.get(1).put(3, 15);
        graph.get(2).put(3, 4);
        calc();
    }

    // Returns true if edge u-v is a valid edge to be
    // include in MST. An edge is valid if one end is
    // already included in MST and other is not in MST.
    static boolean isValidEdge(int u, int v)
    {
        if (u == v)
            return false;
        if (!visited.contains(u) && !visited.contains(v))
            return false;
        else if (visited.contains(u) && visited.contains(v))
            return false;
        return true;
    }

    private static void calc() {

        // Include first vertex in MST
        visited.add(0);

        // Keep adding edges while number of included
        // edges does not become V-1.
        int edge_count = 0, mincost = 0;
        while (edge_count < V - 1)
        {

            // Find minimum weight valid edge.
            int min = Integer.MAX_VALUE, a = -1, b = -1;
            for (int i = 0; i < V; i++)
            {
                for (int j = 0; j < V; j++)
                {
                    if(!graph.get(i).containsKey(j)) continue;
                    if (graph.get(i).get(j) < min)
                    {
                        if (isValidEdge(i, j))
                        {
                            min = graph.get(i).get(j);
                            a = i;
                            b = j;
                        }
                    }
                }
            }

            if (a != -1 && b != -1)
            {
                System.out.printf("Edge %d:(%d, %d) cost: %d \n", edge_count++, a, b, min);
                mincost = mincost + min;
                visited.add(b);
                visited.add(a);
            }
        }
        System.out.printf("\n Minimum cost = %d \n", mincost);
    }
}
