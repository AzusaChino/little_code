package cn.az.code.year2020.oct;

import cn.az.code.common.TreeNode;

/**
 * little-code
 *
 * @author azusachino
 * @since 6/10/2020 21:26
 */
public class InsertIntoBst {

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.right = insert(root.right, val);
        }
        if (root.val < val) {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
        }
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        }
        return root;
    }
}
