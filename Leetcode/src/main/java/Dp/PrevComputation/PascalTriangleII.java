package Dp.PrevComputation;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        if (rowIndex == 0)
        {
            return new ArrayList<>();
        }

        List<Integer> item = new ArrayList<>();
        item.add(1);
        result.add(item);


        for (int i = 1; i <= rowIndex; i++)
        {
            List<Integer> prev = result.get(i-1);
            List<Integer> curr = new ArrayList<>();

            curr.add(1);

            for (int j = 1; j < prev.size(); j++)
            {
                curr.add(prev.get(j-1) + prev.get(j));
            }

            curr.add(1);
            result.add(new ArrayList<>(curr));
        }

        return result.get(rowIndex);
    }
}
