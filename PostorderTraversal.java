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

public class PostorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> results = new ArrayList<Integer>();

        traverse(results, root);

        return results;
    }

    private void traverse(ArrayList<Integer> a, TreeNode node) {
        if (node == null) {
            return;
        }

        traverse(a, node.left);
        traverse(a, node.right);
        a.add(node.val);
    }
}
