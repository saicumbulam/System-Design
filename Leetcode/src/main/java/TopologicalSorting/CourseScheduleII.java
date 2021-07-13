package TopologicalSorting;

import java.util.*;

// use node indegree
// o(v+e) | o(v+e)
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        for(int i = 0; i < numCourses; i++)
        {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, inDegree.getOrDefault(i, 0) + 1);
        }

        for(int[] item: prerequisites)
        {
            graph.get(item[0]).add(item[1]);
            inDegree.put(item[1], inDegree.get(item[1]) + 1);
        }

        Queue<Integer> source = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet())
        {
            if (entry.getValue() == 1)
            {
                source.add(entry.getKey());
            }
        }

        List<Integer> sortedVertex = new ArrayList<>();

        while(!source.isEmpty())
        {
            int size = source.size();
            for(int i = 0; i < size; i++)
            {
                int vertex = source.poll();
                sortedVertex.add(vertex);

                List<Integer> children = graph.get(vertex);
                for(int child: children)
                {
                    inDegree.put(child, inDegree.get(child)-1);
                    if (inDegree.get(child) == 1)
                    {
                        source.add(child);
                        inDegree.remove(child);
                    }
                }
            }
        }

        int[] result = new int[sortedVertex.size()];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = sortedVertex.get(i);
        }
        return result;
    }
}
