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

public class IsValidBST {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */

    private int lastValue;
    private boolean firstNode = true;
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }
        if(!firstNode && lastValue >= root.val) {
            return false;
        } else {
            lastValue = root.val;
        }

        firstNode = false;

        if (!isValidBST(root.right)) {
            return false;
        }

        return true;
    }

}
