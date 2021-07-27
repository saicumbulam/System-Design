package BackTracking;

import java.util.ArrayList;
import java.util.List;

//o(N^(t/m + 1)) | o(t/m)
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Calculate(candidates, 0, target, new ArrayList<>());
        return result;
    }


    private void Calculate(int[] arr, int index, int target, List<Integer> curr)
    {

        if (target == 0)
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (index >= arr.length || target < 0)
        {
            return;
        }


        for(int i = index; i < arr.length; i++)
        {
            curr.add(arr[i]);
            Calculate(arr, i, target - arr[i], curr);
            curr.remove(curr.size() - 1);
        }
    }
}
