package Amazon;

import java.util.*;

public class DebtRecords {
    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        result.add(Arrays.asList("USA","Canada", "2"));
        result.add(Arrays.asList("Canada","USA", "2"));
        result.add(Arrays.asList("Mexico","USA", "5"));
        result.add(Arrays.asList("Canada","Mexico", "7"));
        result.add(Arrays.asList("USA","Canada", "4"));
        result.add(Arrays.asList("USA","Mexico", "4"));
        System.out.println(Calculate(result));
    }

    // create a hashmap with adjusted values. iterate hashmap and put the minimum most values into
    // list
    private static List<String> Calculate(List<List<String>> debts)
    {
        HashMap<String, Integer> map = new HashMap<>();

        for (List<String> record : debts) {

            int amount = Integer.parseInt(record.get(2));
            map.put(record.get(0), map.getOrDefault(record.get(0), 0) - amount);
            map.put(record.get(1), map.getOrDefault(record.get(1), 0) + amount);
            //map.merge(record.get(0), -amount, Integer::sum);
            //map.merge(record.get(1), amount, Integer::sum);
        }

        int minDebt = -1;

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> e : map.entrySet()) {

            int debt = e.getValue();

            if (debt > minDebt) continue;

            if (debt < minDebt) {
                minDebt = debt;
                result.clear();
            }
            result.add(e.getKey());
        }

        if (result.size() == 0) return Arrays.asList("No countries have debt.");
        Collections.sort(result);
        return result;
    }
}
