package cn.az.code.year2021.feb;

import cn.az.code.common.TreeNode;

/**
 * @author ycpang
 * @since 2021-02-02 16:51
 */
public class TrimBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
