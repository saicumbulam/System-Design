package SegmentTree;

public class RangeSumQueryMutable {

    static class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    static SegmentTreeNode root = null;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        root = buildTree(nums, 0, nums.length-1);
        System.out.println(sumRange(0, 2));
        update(1, 2);
        System.out.println(sumRange(0, 2));

    }

    private static SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start == end)
        {
            node.sum = nums[start];
        }
        else
        {
            int mid = start + (end - start)/2;
            if(start <= mid)
            {
                node.left = buildTree(nums, start, mid);
            }
            else
            {
                node.right = buildTree(nums, mid+1,end);
            }
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    static void update(int i, int val) {
        update(root, i, val);
    }
    static void update(SegmentTreeNode root, int pos, int val) {
        if(root.start == pos && root.end == pos)
        {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start)/2;

        if(pos <= mid)
        {
            update(root.left, pos, val);
        }
        else
        {
            update(root.right, pos, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public static int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    public static int sumRange(SegmentTreeNode root, int start, int end) {
        if(root.start == start && root.end == end)
        {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start)/2;
        if(end <= mid)
        {
            return sumRange(root.left, start, end);
        }
        else if(start > mid)
        {
            return sumRange(root.right, start, end);
        }
        else
        {
            return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
        }
    }
}
