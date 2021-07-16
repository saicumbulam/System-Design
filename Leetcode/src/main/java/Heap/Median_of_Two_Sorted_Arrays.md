package Heap;

import java.util.PriorityQueue;

//o(nlogn) | o(n)
public class Median_of_Two_Sorted_Arrays {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b -a);

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        for(int  i = 0; i < nums1.length; i++)
        {
            add(nums1[i]);
        }

        for(int  i = 0; i < nums2.length; i++)
        {
            add(nums2[i]);
        }

        return getMedian();
    }

    private void add(int num)
    {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
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

    private double getMedian()
    {
        if (maxHeap.size() == minHeap.size())
        {
            return (maxHeap.peek()/2.0 + minHeap.peek()/2.0);
        }
        else
        {
            return maxHeap.peek();
        }
    }
}
