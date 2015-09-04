import java.util.*;
/**
 * Definition of TreeNode:
 */
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

/**
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */
public class BSTIterator {

    private Queue<TreeNode> q = new LinkedList<TreeNode>();
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        traverse(root);
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return q.size() != 0;
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        return q.poll();
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        q.offer(root);
        traverse(root.right);
    }

    public static void main(String argv[]) {
        TreeNode n = new TreeNode(10);
        n.left = new TreeNode(1);
        n.right = new TreeNode(11);
        BSTIterator s = new BSTIterator(n);
        System.out.println(s.hasNext());
        System.out.println(s.next().val);
        System.out.println(s.hasNext());
        System.out.println(s.next().val);
        System.out.println(s.hasNext());
        System.out.println(s.next().val);
        System.out.println(s.hasNext());
    }
}
