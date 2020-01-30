package cn.az.code.medium;

import cn.az.code.common.TreeNode;

import java.util.Stack;

/**
 * @author az
 * @date 1/30/2020
 */
public class ValidateBinarySearchTree098 {

    public static void main(String[] args) {
        ValidateBinarySearchTree098 v = new ValidateBinarySearchTree098();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println("v.isValidBst(root) = " + v.isValidBst(root));
    }

    public boolean isValidBst(TreeNode root) {
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

