class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class MaxPathSum {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */

    private class Path {
        public int singlePath;
        public int maxPath;
        public Path(int a, int b) {
            this.singlePath = a;
            this.maxPath = b;
        }
    }
    private Path helper(TreeNode node) {
        if (node == null) {
            return new Path(0, Integer.MIN_VALUE);
        }

        Path pathLeft = helper(node.left);
        Path pathRight = helper(node.right);

        int singlePath = Math.max(pathRight.singlePath, pathLeft.singlePath) + node.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(pathRight.maxPath, pathLeft.maxPath);
        maxPath = Math.max(pathRight.singlePath + pathLeft.singlePath + node.val, maxPath);

        return new Path(singlePath, maxPath);

    }
    public int maxPathSum(TreeNode root) {
        // write your code here
        Path p = helper(root);
        return p.maxPath;
    }
}
