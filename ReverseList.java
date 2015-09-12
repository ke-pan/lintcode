/**
 * Definition for ListNode
 */
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class ReverseList {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        // find prev m and m;
        int i = 0;
        ListNode prevm;
        ListNode nodem;

        for (;i < m - 1; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        prevm = head;
        nodem = head.next;

        // reverse m to n;

        head = head.next;
        i++;
        ListNode prev = null;

        for (;i < n + 1; i++) {
            if (head == null) {
                return null;
            }
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        // link the list

        prevm.next = prev;
        nodem.next = head;
        return dummy.next;
    }
}
