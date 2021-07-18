package DepthFirstSearch.BinaryTree;

public class DiameterofBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int maxDiameter = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
        {
            return 0;
        }

        Calculator(root);
        return maxDiameter-1;
    }

    public int Calculator(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int left = Calculator(root.left);
        int right = Calculator(root.right);

        int diameter = left + right + 1;

        maxDiameter = Math.max(diameter, maxDiameter);

        return Math.max(left, right) + 1;
    }
}
