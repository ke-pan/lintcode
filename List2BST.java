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
/**
 * Definition of TreeNode
 */
  class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
 }

public class List2BST {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        if ( head == null ) {
            return null;
        }

        int n = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }

        return helper(head, n);
    }

    private TreeNode helper(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode node = head;

        for (int i = 1; i < n / 2; i++) {
            node = node.next;
        }


        TreeNode middle = new TreeNode(node.next.val);
        middle.right = helper(node.next.next, n - n/2 - 1);
        node.next = null;
        middle.left = helper(head, n/2);
        return middle;
    }
}
