package BackTracking;

import java.util.ArrayList;
import java.util.List;

//O(kC^k<N) | O(C^k<N)
public class Combinations {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        Find(n,k,1, new ArrayList<>());
        return result;
    }

    private void Find(int n, int k, int index, List<Integer> curr)
    {
        if(k == 0)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i <= n; i++)
        {
            curr.add(i);
            Find(n, k-1, i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}
