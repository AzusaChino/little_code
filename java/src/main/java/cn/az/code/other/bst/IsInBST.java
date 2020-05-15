package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @date 5/14/2020
 */
public class IsInBST {

    boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        return isInBST(root.left, target)
                || isInBST(root.right, target);
    }

    boolean isInBst(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val < target) {
            return isInBST(root.right, target);
        }
        return isInBST(root.left, target);
    }
}
