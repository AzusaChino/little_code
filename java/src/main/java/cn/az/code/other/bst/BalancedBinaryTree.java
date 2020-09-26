package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

/**
 * little-code
 *
 * @author azusachino
 * @since 24/9/2020 23:31
 */
public class BalancedBinaryTree {

    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // greed wrong solution

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = 0, r = 0;
        TreeNode lt = root, rt = root;
        // should return side max height
        while (lt.left != null) {
            l++;
            lt = lt.left;
        }
        while (rt.right != null) {
            r++;
            rt = rt.right;
        }
        if (Math.abs(l - r) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
