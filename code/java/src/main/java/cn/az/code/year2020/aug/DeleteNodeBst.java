package cn.az.code.year2020.aug;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 08/31/20
 */
public class DeleteNodeBst {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode rightSmallest = root.right;
            while (rightSmallest.left != null) {
                rightSmallest = rightSmallest.left;
            }
            rightSmallest.left = root.left;
            return root.right;
        }
        return root;
    }
}
