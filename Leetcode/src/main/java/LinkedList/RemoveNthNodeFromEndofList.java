package LinkedList;

public class RemoveNthNodeFromEndofList {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int skip = length - n;
        curr = head;
        ListNode prev = null;

        while (skip > 0) {
            prev = curr;
            curr = curr.next;
            skip--;
        }


        if (prev != null) {
            prev.next = curr.next;
        } else {
            head = head.next;
        }

        return head;
    }
}
