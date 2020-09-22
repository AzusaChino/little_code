package cn.az.code.other.linkedlist;

import cn.az.code.common.TreeNode;

/**
 * little-code
 *
 * @author azusachino
 * @since 22/9/2020 23:55
 */
public class FlattenBinaryTreeLinkedList {

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode last = cur.left;
                while (last.right != null) {
                    last = last.right;
                }
                last.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(root.val);
        newNode.right = dfs(root.left);
        return newNode;
    }
}
