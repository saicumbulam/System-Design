package Design;

import org.apache.hadoop.util.hash.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// insert delete and get random o(1) algorithmn
public class LoadBalancer {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random = new Random();

    public LoadBalancer() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    // @param server_id add a new server to the cluster
    // @return void
    void add(int server_id) {
        // Write your code here
        int m = list.size();
        map.put(server_id, m);
        list.add(server_id);
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    void remove(int server_id) {
        // Write your code here
        int index = map.get(server_id);
        int lastElement = list.get(list.size()-1);
        list.set(index, lastElement);
        map.remove(server_id);
        map.put(lastElement, index);
        list.remove(list.size()-1);
    }

    // @return pick a server in the cluster randomly with equal probability
    int pick() {
        // Write your code here
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}