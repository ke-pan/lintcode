
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

public class ReorderList {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        // find mid
        if (head == null) {
            return;
        }

        ListNode mid = head;
        ListNode tail = head.next;

        while (tail != null && tail.next != null) {
            tail = tail.next.next;
            mid = mid.next;
        }

        // reverse mid

        ListNode prev = null;
        ListNode node = mid.next;
        mid.next = null;

        while(node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }

        // merge
        ListNode list1 = head;
        ListNode list2 = prev;
        node = new ListNode(0);
        node.next = head;
        while(list1 != null && list2 != null) {
            head = list1;
            head = head.next;
            head = list2;
            head = head.next;
            list1 = list1.next;
            list2 = list2.next;
        }
        head = list1;
        head = node.next;
    }
}
