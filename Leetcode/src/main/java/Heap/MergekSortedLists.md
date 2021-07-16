package LinkedList;

import java.util.PriorityQueue;

public class MergekSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
        {
            return null;
        }
        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode item : lists)
        {
            if (item != null)
            {
                minHeap.add(item);
            }

        }

        ListNode resultHead = null;
        ListNode resultTail = null;

        while(!minHeap.isEmpty())
        {
            ListNode polled = minHeap.poll();

            if (resultHead == null)
            {
                resultHead = polled;
                resultTail = resultHead;
            }
            else
            {
                resultTail.next = polled;
                resultTail = resultTail.next;
            }

            if (polled.next != null)
            {
                minHeap.add(polled.next);
            }
        }

        return resultHead;
    }
}
