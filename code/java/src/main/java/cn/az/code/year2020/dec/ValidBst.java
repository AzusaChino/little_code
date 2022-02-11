package cn.az.code.year2020.dec;

import cn.az.code.common.TreeNode;

import java.util.Stack;

/**
 * @author az
 * @since 12/16/20 21:19
 */
public class ValidBst {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
