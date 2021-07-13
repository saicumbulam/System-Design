package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//o(2^n) | o(n)
public class CombinationSumII {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        if (num.length == 0) return new ArrayList<>();
        Find(num, target, 0,new ArrayList<>());
        return result;
    }

    private void Find(int[] num, int target, int index, List<Integer> curr)
    {
        if (target == 0)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) return;

        for (int i = index; i < num.length; i++)
        {
            if (i > index && num[i] == num[i-1]) continue;
            curr.add(num[i]);
            Find(num, target - num[i], i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}
