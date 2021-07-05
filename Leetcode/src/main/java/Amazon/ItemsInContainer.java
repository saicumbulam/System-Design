package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ItemsInContainer {
    public static void main(String[] args) {
        String str = "|**|*|*";
        List<List<Integer>> ranges = new ArrayList<>();
        ranges.add(Arrays.asList(0, 4));
        ranges.add(Arrays.asList(1, 6));
        System.out.println(Calculate(str, ranges));
    }

    private static List<Integer> Calculate(String str, List<List<Integer>> ranges)
    {
        int n = str.length();

        HashMap<Integer, Integer> prefixSums = new HashMap<>();

        int curSum = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '|')
                prefixSums.put(i, curSum);
            else
                curSum++;
        }

        int[] leftBounds = new int[n];
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '|')
                last = i;
            leftBounds[i] = last;
        }

        int[] rightBounds = new int[n];
        last = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == '|')
                last = i;
            rightBounds[i] = last;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < ranges.size(); i++) {

            int start = rightBounds[ranges.get(i).get(0)];

            int end = leftBounds[ranges.get(i).get(1)];

            if (start != -1 && end != -1 && start < end)

                res.add(prefixSums.get(end) - prefixSums.get(start));
            else
                res.add(0);

        }

        return res;
    }
}
