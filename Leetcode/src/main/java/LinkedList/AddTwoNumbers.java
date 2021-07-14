package LinkedList;

public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode resultHead = null;
        ListNode resultTail = null;

        while( l1 != null || l2 != null || carry > 0)
        {
            sum = carry;
            if(l1 != null)
            {
                sum += l1.val;
            }
            if(l2 != null)
            {
                sum += l2.val;
            }

            carry = sum/10;

            if(resultHead == null)
            {
                resultHead = new ListNode(sum%10);
                resultTail = resultHead;
            }
            else
            {
                resultTail.next = new ListNode(sum%10);
                resultTail = resultTail.next;
            }

            if(l1 != null)
            {
                l1 = l1.next;
            }

            if(l2 != null)
            {
                l2 = l2.next;
            }
        }

        return resultHead;
    }
}
