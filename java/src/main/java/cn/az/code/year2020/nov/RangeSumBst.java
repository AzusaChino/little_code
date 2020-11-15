package cn.az.code.year2020.nov;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 11/15/20
 */
public class RangeSumBst {

    int result = 0;

    public static void main(String[] args) {
        RangeSumBst rsb = new RangeSumBst();
        TreeNode root = new TreeNode(10);
        root.right = TreeNode.of(11);
        root.left = TreeNode.of(7);
        root.left.right = TreeNode.of(8);
        System.out.println(rsb.rangeSumBST(root, 7, 10));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        return sum;

    }
}
