# Find Median from Data Stream

```java
class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) 
    {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num)
        {
            maxHeap.add(num);
        }
        else
        {
            minHeap.add(num);
        }
        
        if (maxHeap.size() > minHeap.size()+1)
        {
            minHeap.add(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
        {
            return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
        }
        return maxHeap.peek();
    }
}
```

