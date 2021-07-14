package LinkedList;

public class ReverseNodesinkGroup {
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
    public ListNode reverseKGroup(ListNode node, int k) {
        ListNode prev = null;
        ListNode curr = node;
        int ListLength = Length(node);

        int count = 0;

        while(count+k <= ListLength)
        {
            ListNode lastNodePrev = prev;
            ListNode lastNodeSubList = curr;

            for(int i = 0; curr != null && i < k; i++)
            {
                count++;
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if (lastNodePrev != null)
            {
                lastNodePrev.next = prev;
            }
            else
            {
                node = prev;
            }

            lastNodeSubList.next = curr;

            if (curr == null)
            {
                break;
            }
            prev = lastNodeSubList;

        }

        return node;
    }

    private int Length(ListNode node)
    {
        int count = 0;
        while(node != null)
        {
            count++;
            node = node.next;
        }
        return count;
    }
}
