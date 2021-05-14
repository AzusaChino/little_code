package cn.az.code.year2021.may;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 2021-05-14
 */
public class FlattenBinaryTreeToLinkedList {

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}