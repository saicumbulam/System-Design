package DepthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
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

    public TreeNode invertTree(TreeNode root) {
        TreeNode curr = root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(curr);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode polled = queue.poll();

                TreeNode tmp = polled.left;
                polled.left = polled.right;
                polled.right = tmp;

                if (polled.left != null)
                {
                    queue.add(polled.left);
                }

                if (polled.right != null)
                {
                    queue.add(polled.right);
                }
            }
        }

        return root;
    }
}
