/**
 * Definition of TreeNode:
 */
import java.util.*;
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class PreorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */

    // Traverse
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> results = new ArrayList<Integer>();

        travel(results, root);

        return results;
    }

    private void travel(ArrayList<Integer> a, TreeNode node) {
        if (node == null) {
            return;
        }

        a.add(node.val);
        travel(a, node.left);
        travel(a, node.right);
        return;
    }

    // Devide and Conquer
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();

        if (root == null) {
            return results;
        }

        results.add(root.val);
        results.addAll(preorderTraversal1(root.left));
        results.addAll(preorderTraversal1(root.right));

        return results;

    }


}
