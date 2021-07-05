/*
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not
Time : O(N)
space: O(1)
* */
package FastSlow;

public class StartOfLinkedList {
    class ListNode
    {
        int value;
        ListNode next;
    }
    private static ListNode Calculate(ListNode root) {

        ListNode slow = root.next, fast = root.next.next;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = root;

        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
