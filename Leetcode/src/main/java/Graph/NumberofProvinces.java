package Graph;

import java.util.HashSet;

public class NumberofProvinces {
    HashSet<Integer> set = new HashSet<>();

    public int findCircleNum(int[][] M) {
        int count = 0;
        for(int i = 0; i < M.length; i++) {
            if(!set.contains(i)) {
                dfs(M, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int person) {

        for(int other = 0; other < M.length; other++) {
            if(M[person][other] == 1 && !set.contains(other)) {
                //We found an unvisited person in the current friend cycle
                set.add(other);
                dfs(M, other); //Start DFS on this new found person
            }
        }
    }
}
