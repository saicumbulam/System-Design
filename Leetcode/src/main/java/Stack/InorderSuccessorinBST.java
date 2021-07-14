package Stack;

import java.util.Stack;

public class InorderSuccessorinBST {
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;

        while(!stack.isEmpty() || root != null)
        {
            if (root != null)
            {
                stack.add(root);
                root = root.left;
                continue;
            }
            root = stack.pop();

            if (prev != null && prev.val == p.val)
            {
                return root;
            }
            prev = root;
            root = root.right;
        }

        return null;
    }
}
