package BinaryTree;

import DepthFirstSearch.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class BalanceaBinarySearchTree {
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

    List<Integer> list;

    public TreeNode balanceBST(TreeNode root) {
        if(root == null)
        {
            return null;
        }

        list = new ArrayList<>();
        GetOrder(root, list);

        return balanced(0, list.size());
    }

    private TreeNode balanced(int low, int high)
    {
        if(high <= low) return null;
        int mid = low + (high - low)/2;
        TreeNode newNode = new TreeNode(list.get(mid));
        newNode.left = balanced(low, mid);
        newNode.right = balanced(mid+1, high);

        return newNode;

    }

    private void GetOrder(TreeNode root, List<Integer> list)
    {
        if (root == null) return;

        GetOrder(root.left, list);

        list.add(root.val);

        GetOrder(root.right, list);

    }
}
