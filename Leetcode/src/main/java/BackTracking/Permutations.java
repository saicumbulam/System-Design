package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//P(N,k)= N!/(N−k)! | O(N)
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        for(int num: nums)
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                List<Integer> oldList = queue.poll();
                for(int j = 0; j <= oldList.size(); j++)
                {
                    List<Integer> newList = new ArrayList<>(oldList);
                    newList.add(j, num);
                    if(newList.size() == nums.length)
                    {
                        result.add(newList);
                    }
                    else
                    {
                        queue.add(newList);
                    }
                }
            }
        }

        return result;
    }
}
