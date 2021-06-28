package Design;

import java.util.TreeSet;

public class HashingSet {
    private TreeSet<Integer>[] bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public HashingSet() {
        this.keyRange = 769;
        this.bucketArray = new TreeSet[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i)
            this.bucketArray[i] = new TreeSet<>();
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].add(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].contains(key);
    }
}