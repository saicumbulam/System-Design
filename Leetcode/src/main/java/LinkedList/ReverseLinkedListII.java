package LinkedList;

public class ReverseLinkedListII {
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
    public ListNode reverseBetween(ListNode root, int p, int q) {
        ListNode curr = root;
        ListNode prev = null;
        ListNode next = null;

        for(int i = 0; i < p-1; i++)
        {
            prev = curr;
            curr = curr.next;
        }

        ListNode LastNodeFirstPart = prev; //points to p-1
        ListNode LastNodesubList = curr;
        for(int i = 0; i < q-p+1 && curr != null; i++)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(LastNodeFirstPart != null)
        {
            LastNodeFirstPart.next = prev;
        }
        else
        {
            root = prev;
        }

        LastNodesubList.next = curr;

        return root;

    }
}
