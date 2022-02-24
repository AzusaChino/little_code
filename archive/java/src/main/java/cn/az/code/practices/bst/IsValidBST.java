package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @date 5/14/2020
 */
public class IsValidBST {

    public boolean isValid(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValid(root.left, min, root)
                && isValid(root.right, root, max);
    }
}
