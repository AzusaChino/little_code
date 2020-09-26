package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

/**
 * little-code
 *
 * @author azusachino
 * @since 25/9/2020 00:02
 */
public class DeepestLeavesSum {

    private int sum = 0;
    private int deepestLevel;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 1);
        return sum;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // reach the bottom
        if (root.left == null && root.right == null) {
            if (level > deepestLevel) {
                deepestLevel = level;
                sum = root.val;
            } else if (level == deepestLevel) {
                sum += root.val;
            }
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
