package Design;

import java.util.HashMap;
import java.util.LinkedList;

//TODO: Dont Remember
public class LRUCache {
    class Cache {

        class Node
        {
            int key;
            int val;

            public Node(int key, int val)
            {
                this.key = key;
                this.val = val;
            }
        }

        int capacity = 0;
        LinkedList<Node> dll;
        HashMap<Integer, Node> map;

        public Cache(int capacity) {
            this.capacity = capacity;
            dll = new LinkedList<>();
            map = new HashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key))
            {
                Node newNode = map.get(key);
                dll.remove(newNode);
                dll.addFirst(newNode);
                return newNode.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key))
            {
                dll.remove(map.get(key));
            }
            else if (map.size() >= capacity)
            {
                Node tail = dll.removeLast();
                //dll.remove(tail);
                map.remove(tail.key);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            dll.addFirst(newNode);
        }
    }
}
