package FastSlow;

public class MiddleLinkedList {
    class ListNode
    {
        int value;
        ListNode next;
    }

    private static ListNode Calculate(ListNode root)
    {
        ListNode slow = root, fast = root;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
