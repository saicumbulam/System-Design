package Heap;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // keep k largest elements in the heap
        for (int n: nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // output
        return minHeap.poll();
    }
}
