package LinkedList;

public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast.next != null) {
                fast = fast.next;
                if (slow == fast) {
                    isCycle = true;
                    break;
                }
            }

        }


        if (!isCycle) return null;

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;


    }
}
