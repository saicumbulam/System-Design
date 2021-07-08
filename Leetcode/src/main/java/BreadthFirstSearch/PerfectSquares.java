package BreadthFirstSearch;

import java.util.*;

public class PerfectSquares {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(n);
        set.add(n);
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= n/2; i++)
        {
            squares.add(i*i);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                int polled = queue.poll();
                for (int j = 0; j < squares.size(); j++) {
                    int square = squares.get(j);
                    if(polled - square == 0)
                    {
                        return level+1;
                    }
                    if(square > polled) continue;

                    if(polled >= square && !set.contains(polled - square))
                    {
                        queue.add(polled - square);
                        set.add(polled - square);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
