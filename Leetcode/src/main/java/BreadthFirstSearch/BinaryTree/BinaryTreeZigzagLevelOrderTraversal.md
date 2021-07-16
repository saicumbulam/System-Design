package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
        {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while(!queue.isEmpty())
        {
            int listSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < listSize; i++)
            {
                TreeNode polled = queue.poll();

                if (leftToRight)
                {
                    currentLevel.add(polled.val);
                }
                else
                {
                    currentLevel.add(0, polled.val);
                }

                if (polled.left != null)
                {
                    queue.add(polled.left);
                }

                if (polled.right != null)
                {
                    queue.add(polled.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(currentLevel);
        }

        return result;

    }
}
