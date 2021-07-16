package TwoPointers.LinkedList;

public class RemoveDuplicatesfromSortedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null)
        {
            if(curr.next != null && curr.val == curr.next.val)
            {
                while(curr.next != null && curr.val == curr.next.val)
                {
                    curr = curr.next;
                }
                if (prev != null)
                    prev.next = curr;
                else
                    head = curr;
                prev = curr;
            }
            else
            {
                prev = curr;
            }

            curr = curr.next;

        }

        return head;
    }
}
