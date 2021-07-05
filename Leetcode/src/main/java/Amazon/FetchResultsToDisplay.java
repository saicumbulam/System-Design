package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FetchResultsToDisplay {
    public static void main(String[] args) {
        HashMap<String, int[]> map = new HashMap<>();
        map.put("foo.com", new int[]{10, 15});
        map.put("bar.com", new int[]{3, 4});
        map.put("baz.com", new int[]{17, 9});
        System.out.println(Calculate(1,0,2, 1, map));
    }

    public static List<String> Calculate(int sortColumn, int sortOrder, int pageSize, int pageIndex,
                                         HashMap<String, int[]> results) {

        List<String> result = new ArrayList<>(results.keySet()); // create a list of result names

        result.sort((a, b) -> {

            int res;

            if (sortColumn == 0) { // compare result name alphabetical

                res = a.compareTo(b);

            } else {

                // compare by relevance or price. sortParamter - 1 because subtracting the result name spot

                res = results.get(a)[sortColumn - 1] - results.get(b)[sortColumn - 1];

            }

            return res * (sortOrder == 0 ? 1 : -1); // if reverse order, then * -1
        });

        int startIndex = pageSize * pageIndex;

        return result.subList(startIndex, Math.min(startIndex + pageSize, result.size()));
    }
}
