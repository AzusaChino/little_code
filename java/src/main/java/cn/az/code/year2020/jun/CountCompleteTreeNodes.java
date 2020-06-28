package cn.az.code.year2020.jun;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 2020-06-23 20:16
 */
public class CountCompleteTreeNodes {

    /**
     * @param root root
     * @return count
     */
    public int countNodes(TreeNode root) {
        int h = helper(root);
        return h < 0 ? 0 :
                helper(root.right) == h - 1 ? (1 << h) + countNodes(root.right) : (1 << (h - 1)) + countNodes(root.left);
    }

    private int helper(TreeNode root) {
        return root == null ? -1 : 1 + helper(root.left);
    }

    public int _countNodes(TreeNode root) {
        int nodes = 0, h = helper(root);
        while (root != null) {
            if (helper(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
}
