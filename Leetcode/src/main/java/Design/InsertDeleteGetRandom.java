package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandom {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    int count = 0;
    Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
        {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
        {
            return false;
        }

        int lastElement = list.get(list.size()-1);
        int index = map.get(val);
        map.put(lastElement, index);
        map.remove(val);
        list.set(index, lastElement);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
