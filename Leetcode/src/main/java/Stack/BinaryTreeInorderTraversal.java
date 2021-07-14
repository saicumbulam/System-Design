package Stack;

import DepthFirstSearch.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || stack.size() > 0)
        {
            if (root != null)
            {
                stack.push(root);
                root = root.left;
                continue;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }
}
