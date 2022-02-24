package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 09/08/20
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = 10 * val + root.val;
        if (root.left == root.right) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }
}
