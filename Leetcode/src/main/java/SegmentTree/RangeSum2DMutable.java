package SegmentTree;

public class RangeSum2DMutable {
    static class TreeNode {
        int row1, row2, col1, col2, sum;
        TreeNode c1, c2, c3, c4;
        public TreeNode (int row1, int col1, int row2, int col2) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.sum = 0;
        }
    }

    static TreeNode root;

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        root = buildTree(matrix, 0, 0, matrix.length-1, matrix[0].length-1);
        System.out.println(sumRegion(2,1,4,3));
        update(3, 2, 2);
        System.out.println(sumRegion(2, 1,4,3));
    }
    private static TreeNode buildTree(int[][] matrix, int row1, int col1, int row2, int col2) {
        if (row2 < row1 || col2 < col1) return null;

        TreeNode node = new TreeNode(row1, col1, row2, col2);
        if (row1 == row2 && col1 == col2) {
            node.sum = matrix[row1][col1];
            return node;
        }

        int rowMid = row1 + (row2 - row1) / 2;
        int colMid = col1 + (col2 - col1) / 2;
        node.c1 = buildTree(matrix, row1, col1, rowMid, colMid);
        node.c2 = buildTree(matrix, row1, colMid+1, rowMid, col2);
        node.c3 = buildTree(matrix, rowMid+1, col1, row2, colMid);
        node.c4 = buildTree(matrix, rowMid+1, colMid+1, row2, col2);

        node.sum += (node.c1 == null) ? 0 : node.c1.sum;
        node.sum += (node.c2 == null) ? 0 : node.c2.sum;
        node.sum += (node.c3 == null) ? 0 : node.c3.sum;
        node.sum += (node.c4 == null) ? 0 : node.c4.sum;
        return node;
    }

    public static void update(int row, int col, int val) {
        updateTree(root, row, col, val);
    }

    private static void updateTree(TreeNode root, int row, int col, int val) {
        if (root == null) return;

        if (row < root.row1 || row > root.row2 || col < root.col1 || col > root.col2)
            return;

        if (root.row1 == root.row2 && root.row1 == row &&
                root.col1 == root.col2 && root.col1 == col) {
            root.sum = val;
            return;
        }

        updateTree(root.c1, row, col, val);
        updateTree(root.c2, row, col, val);
        updateTree(root.c3, row, col, val);
        updateTree(root.c4, row, col, val);

        root.sum = 0;
        root.sum += (root.c1 == null) ? 0 : root.c1.sum;
        root.sum += (root.c2 == null) ? 0 : root.c2.sum;
        root.sum += (root.c3 == null) ? 0 : root.c3.sum;
        root.sum += (root.c4 == null) ? 0 : root.c4.sum;
    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegionTree(root, row1, col1, row2, col2);
    }

    private static int sumRegionTree(TreeNode root, int row1, int col1, int row2, int col2) {
        if (root == null) return 0;

        if (root.row2 < row1 || root.row1 > row2 || root.col2 < col1 || root.col1 > col2)
            return 0;

        if (root.row1 >= row1 && root.row2 <= row2 && root.col1 >= col1 && root.col2 <= col2)
            return root.sum;

        return sumRegionTree(root.c1, row1, col1, row2, col2) +
                sumRegionTree(root.c2, row1, col1, row2, col2) +
                sumRegionTree(root.c3, row1, col1, row2, col2) +
                sumRegionTree(root.c4, row1, col1, row2, col2);
    }
}
