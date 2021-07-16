package DepthFirstSearch.SortedArrayToBST;

// o(n) | o(n) : explanation needed
public class ConvertSortedArraytoBinarySearchTree {
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


    public TreeNode sortedArrayToBST(int[] nums) {
        return Finder(nums, 0, nums.length);
    }

    private TreeNode Finder(int[] nums, int start, int end)
    {
        if (start >= end)
        {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = Finder(nums, start, mid);
        root.right =  Finder(nums, mid+1, end);
        return root;
    }
}
