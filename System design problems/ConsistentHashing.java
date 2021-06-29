package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ConsistentHashing {
    HashMap<Integer, Integer> shards;
    HashSet<Integer> ids;
    Random rand = new Random();
    int n, k;

    public ConsistentHashing() {
        this.shards = new HashMap<>();
        this.ids = new HashSet<>();
    }

    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    static Solution create(int n, int k) {
        // Write your code here
        Solution sol;
        sol.n = n;
        sol.k = k;
        return sol;
    }

    // @param machine_id an integer
    // @return a list of shard ids
    List<Integer> addMachine(int machine_id) {
        // Write your code here
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            int node;
            do {
                node = rand() % n;
            } while (ids.find(node) != ids.end());
            shards[node] = machine_id;
            ids.insert(node);
            nodes.push_back(node);
        }
        return nodes;
    }

    // @param hashcode an integer
    // @return a machine id
   int getMachineIdByHashCode(int hashcode) {
       // Write your code here
       auto it = shards.lower_bound(hashcode);
       if (it != shards.end()) {
           return it->second;
       } else {
           return shards.begin()->second;
       }
   }
}