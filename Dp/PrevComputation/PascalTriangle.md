package Dp.PrevComputation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//o(numrow^2) | o(numrow^2)
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        result.add(Arrays.asList(1));
        if(numRows == 1) return result;

        for (int i = 2; i <= numRows; i++) {
            List<Integer> prev = result.get(result.size() -1);
            List<Integer> curr = new ArrayList<>();

            curr.add(1);

            for (int j = 1; j < prev.size(); j++) {
                curr.add(prev.get(j-1) + prev.get(j));
            }
            curr.add(1);
            result.add(curr);
        }
        return result;
    }
}
