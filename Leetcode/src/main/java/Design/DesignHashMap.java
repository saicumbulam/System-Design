package Design;

import java.util.ArrayList;
import java.util.List;

public class DesignHashMap {
    class MyHashMap {

        // to store chains of slots
        List<HashEntry> bucket;
        int slots;
        int size;

        /** Initialize your data structure here. */
        public MyHashMap() {
            bucket = new ArrayList<HashEntry>();
            size = 0;
            slots = 5;
            for(int i = 0; i < slots; i++)
            {
                bucket.add(null);
            }
        }

        public int size() { return size; }
        public boolean isEmpty() { return size() == 0; }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int b_Index = getIndex(key);
            HashEntry head = bucket.get(b_Index);
            // See if the key exists
            while (head != null)
            {
                if (head.key == key)
                {
                    head.value = value;
                    return;
                }
                head = head.next;
            }

            // Insert key into the bucket
            size++;
            head = bucket.get(b_Index);
            HashEntry new_slot = new HashEntry(key, value);
            new_slot.next = head;
            bucket.set(b_Index, new_slot);

            //If 60% of the array gets filled, double the size
            if ((1.0*size)/slots >= 0.6)
            {
                List <HashEntry> temp = bucket;
                bucket = new ArrayList<>();
                slots = 2 * slots;
                size = 0;
                for (int i = 0; i < slots; i++)
                    bucket.add(null);

                for (HashEntry head_Node : temp)
                {
                    while (head_Node != null)
                    {
                        put(head_Node.key, head_Node.value);
                        head_Node = head_Node.next;
                    }
                }
            }
        }

        private int getIndex(int key)
        {
            int index = key % slots;
            return index;
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            if (isEmpty()) return -1;
            int b_Index = getIndex(key);
            HashEntry head = bucket.get(b_Index);

            // Find the key in slots
            while (head != null)
            {
                if (head.key == key)
                    return head.value;
                head = head.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int b_Index = getIndex(key);

            HashEntry head = bucket.get(b_Index);

            // Search the key in slots
            HashEntry prev = null;
            while (head != null)
            {
                // If the key exists
                if (head.key == key)
                    break;

                //If the key not found yet
                prev = head;
                head = head.next;
            }

            // If the key does not exist
            if (head == null)
                return;

            size--;

            // Delete the value by  key
            if (prev != null)
                prev.next = head.next;
            else
                bucket.set(b_Index, head.next);

            return;
        }
    }


    class HashEntry
    {
        int key;
        int value;
        HashEntry next;

        // Constructor
        public HashEntry(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
}
