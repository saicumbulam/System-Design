package DepthFirstSearch.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
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

    List<TreeNode> result;
    HashMap<String, Integer> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new ArrayList<>();
        map = new HashMap<>();

        Calc(root);
        return result;
    }


    private String Calc(TreeNode root)
    {
        if(root == null) return "";

        String val = String.valueOf(root.val) + "," +
                Calc(root.left) + "," + Calc(root.right);

        map.put(val, map.getOrDefault(val, 0) + 1);
        if(map.get(val) == 2 )
        {
            result.add(root);
        }

        return val;
    }
}
