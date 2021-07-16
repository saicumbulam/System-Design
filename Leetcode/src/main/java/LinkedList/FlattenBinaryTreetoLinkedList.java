package LinkedList;

public class FlattenBinaryTreetoLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        Calculate(root);

    }

    private void Calculate(TreeNode root) {
        if (root == null) return;

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode rightMost = curr.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                rightMost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }


            curr = curr.right;
        }
    }
}
