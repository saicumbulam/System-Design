# Zigzag Iterator

![](../../.gitbook/assets/image%20%286%29.png)

o\(1\) \| o\(k\)

```java
public class ZigzagIterator {

    Queue<Iterator> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Iterator>();
        if(!v1.isEmpty()) queue.add(v1.iterator());
        if(!v2.isEmpty()) queue.add(v2.iterator());
    }

    public int next() {
        Iterator poll = queue.remove();
        int result = (Integer)poll.next();
        if(poll.hasNext()) queue.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
```

