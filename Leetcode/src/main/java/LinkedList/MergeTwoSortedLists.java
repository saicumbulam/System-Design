package LinkedList;

public class MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultHead = null;
        ListNode resultTail;

        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val)
        {
            resultHead = new ListNode(l1.val);
            l1 = l1.next;
        }
        else
        {
            resultHead = new ListNode(l2.val);
            l2 = l2.next;
        }

        resultTail = resultHead;

        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                resultTail.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else
            {
                resultTail.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            resultTail = resultTail.next;
        }

        if(l1 != null)
        {
            resultTail.next = l1;
        }
        if(l2 != null)
        {
            resultTail.next = l2;
        }
        return resultHead;
    }
}
