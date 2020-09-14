package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 09/14/20
 */
public class MaximumDepth {

    private int result;

    /**
     * top down
     *
     * @param root root
     * @return maximumDepth
     */
    public int maximumDepth(TreeNode root) {
        dfs(root, 1);
        return result;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result = Math.max(result, depth);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    /**
     * bottom up
     *
     * @param root root
     * @return maximumDepth
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 探到最深的一个子树后 开始回滚
        return Math.max(left, right) + 1;
    }
}
