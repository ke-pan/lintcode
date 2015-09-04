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

public class BSTSearchRange {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> results = new ArrayList<Integer>();

        if (root == null) {
            return results;
        }

        ArrayList<Integer> left = searchRange(root.left, k1, k2);
        ArrayList<Integer> right = searchRange(root.right, k1, k2);

        results.addAll(left);
        if (k1 <= root.val && root.val <= k2) {
            results.add(root.val);
        }
        results.addAll(right);

        return results;
    }
}
