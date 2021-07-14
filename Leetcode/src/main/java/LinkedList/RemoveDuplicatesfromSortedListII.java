package LinkedList;

public class RemoveDuplicatesfromSortedListII {
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
    public ListNode deleteDuplicates(ListNode head) {
        // sentinel
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (curr.next != null && curr.val == curr.next.val) {
                // move till the end of duplicates sublist
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // skip all duplicates
                if(prev != null)
                    prev.next = curr.next;
                else
                    head = curr.next;
                //prev = prev.next;
                // otherwise, move predecessor
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
