package FastSlow;

public class LinkedListCycle {
    class ListNode
    {
        int value;
        ListNode next;
    }
    private static boolean Calculate(ListNode root)
    {
        ListNode slow = root, fast = root;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
            {
                return true;
            }
        }
        return false;
    }
}
