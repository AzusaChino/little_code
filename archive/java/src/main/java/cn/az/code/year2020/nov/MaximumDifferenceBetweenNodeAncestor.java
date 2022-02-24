package cn.az.code.year2020.nov;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 11/09/20
 */
public class MaximumDifferenceBetweenNodeAncestor {

    public int maxDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int l, int r) {
        if (root == null) {
            return 0;
        }
        l = Math.max(l, root.val);
        r = Math.min(r, root.val);

        int l1 = dfs(root.left, l, r);
        int r1 = dfs(root.right, l, r);

        return Math.max(l - r, Math.max(l1, r1));
    }
}
