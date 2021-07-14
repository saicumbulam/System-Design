package LinkedList;

public class PartitionList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode lesserHead = new ListNode(0), greaterHead = new ListNode(0);
        ListNode lesserTail = lesserHead, greaterTail = greaterHead;

        while (head!=null){
            if (head.val < x) {
                lesserTail.next = head;
                lesserTail = head;
            }else {
                greaterTail.next = head;
                greaterTail = head;
            }
            head = head.next;
        }
        greaterTail.next = null;
        lesserTail.next = greaterHead.next;
        return lesserHead.next;
    }
}
