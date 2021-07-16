package TwoPointers.LinkedList;

public class RotateList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;

        ListNode curr = head;


        while(curr.next != null)
        {
            curr = curr.next;
            n++;
        }
        curr.next = head;

        ListNode prev = null;
        curr = head;
        n += 1;

        k %= n;
        if(k < 0)
        {
            k += n;
        }

        int skip = n - k;

        while(skip > 0)
        {
            prev = curr;
            curr = curr.next;
            skip--;
        }

        if(prev != null)
        {
            prev.next = null;
        }
        head = curr;
        return head;
    }
}
