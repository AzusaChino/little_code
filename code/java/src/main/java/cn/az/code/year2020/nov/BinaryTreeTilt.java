package cn.az.code.year2020.nov;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 11/08/20
 */
public class BinaryTreeTilt {

    int result = 0;

    public int findTilt(TreeNode root) {

        traverse(root);
        return result;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        result += helper(root);
        traverse(root.left);
        traverse(root.right);
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = count(node.left);
        int right = count(node.right);

        return Math.abs(left - right);
    }


    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = count(node.left);
        int right = count(node.right);
        return left + right + node.val;
    }

}
