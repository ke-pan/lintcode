import java.util.*;
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class LevelOrder {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return results;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(q.size() != 0) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                level.add(n.val);
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
            results.add(level);
        }

        return results;
    }
}
