package cn.az.code.year2021.aug;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 2021-08-17
 */
public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        return goodNodes(root, -10000);
    }

    public int goodNodes(TreeNode root, int ma) {
        if (root == null) return 0;
        int res = root.val >= ma ? 1 : 0;
        res += goodNodes(root.left, Math.max(ma, root.val));
        res += goodNodes(root.right, Math.max(ma, root.val));
        return res;
    }
}
