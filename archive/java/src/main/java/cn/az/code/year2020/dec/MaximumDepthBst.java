package cn.az.code.year2020.dec;

import cn.az.code.common.TreeNode;

/**
 * @author pangy
 * @since 12/01/20
 */
public class MaximumDepthBst {

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }
}
