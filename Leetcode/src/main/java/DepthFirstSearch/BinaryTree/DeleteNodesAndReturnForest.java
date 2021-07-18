package DepthFirstSearch.BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
* */
public class DeleteNodesAndReturnForest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    HashSet<Integer> set = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int item: to_delete)
        {
            set.add(item);
        }

        Finder(root);
        if (!set.contains(root.val))
        {
            list.add(root);
        }
        return list;
    }

    private TreeNode Finder(TreeNode root)
    {
        if (root == null) return null;

        root.left = Finder(root.left);
        root.right = Finder(root.right);

        if (set.contains(root.val))
        {
            if (root.left != null)
            {
                list.add(root.left);
            }

            if (root.right != null)
            {
                list.add(root.right);
            }

            return null;
        }

        return root;
    }

}
