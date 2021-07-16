package DepthFirstSearch.BinaryTree;

public class ValidateBinarySearchTree {
    public class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return Calculate(root, null, null);
    }

    private boolean Calculate(TreeNode root, Integer low, Integer high)
    {
        if (root == null) return  true;

        if (low != null && root.val <= low)
        {
            return false;
        }

        if (high != null && root.val >= high)
        {
            return false;
        }

        return Calculate(root.left, low, root.val) &&
                Calculate(root.right, root.val, high);
    }
}
