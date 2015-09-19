/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class SortList {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMedian(head);
        ListNode right = mid.next;
        mid.next = null;
        head = sortList(head);
        right = sortList(right);
        return merge(head, right);

    }

    private ListNode findMedian(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        while (a != null && b != null) {
            if(a.val < b.val) {
                node.next = a;
                a = a.next;
            } else {
                node.next = b;
                b = b.next;
            }
            node = node.next;
        }
        if (a == null) {
            node.next = b;
        } else {
            node.next = a;
        }
        return result.next;
    }

}
