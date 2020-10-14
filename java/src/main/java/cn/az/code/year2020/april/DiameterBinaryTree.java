package cn.az.code.year2020.april;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 10/14/20
 */
public class DiameterBinaryTree {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }

    public int diameterOfBinaryTree_(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return oneSideMax(root.left) + oneSideMax(root.right);
    }

    public int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(oneSideMax(root.left), oneSideMax(root.right));
    }
}
