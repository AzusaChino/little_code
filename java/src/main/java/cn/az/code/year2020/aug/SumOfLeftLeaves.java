package cn.az.code.year2020.aug;

import cn.az.code.common.TreeNode;

import java.util.Stack;

/**
 * @author az
 * @since 08/24/20
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves1(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }
        return helper(root.left, true) + helper(root.right, false);
    }

    public int sumOfLeftLeavesRecursive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeavesRecursive(root.left);
            }
        }
        ans += sumOfLeftLeavesRecursive(root.right);

        return ans;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int res = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    res += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return res;
    }
}
