/**
 * Definition for ListNode.
 */
  class ListNode {
     int val;
     ListNode next;
     ListNode(int val) {
         this.val = val;
         this.next = null;
     }
 }

public class ListPartition {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode nodeL = left;
        ListNode nodeR = right;

        while (head != null) {
            ListNode temp  = head.next;
            if (head.val < x) {
                nodeL.next = head;
                nodeL = nodeL.next;
                nodeL.next = null;
            } else {
                nodeR.next = head;
                nodeR = nodeR.next;
                nodeR.next = null;
            }
            head = temp;
        }
        nodeL.next = right.next;
        return left.next;
    }
}
