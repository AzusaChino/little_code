package cn.az.code.year2021.mar;

import cn.az.code.common.TreeNode;

/**
 * @author ycpang
 * @since 2021-03-09 16:36
 */
public class AddOneRowTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 0 || d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = d == 1 ? root : null;
            newRoot.right = d == 0 ? root : null;
            return newRoot;
        }
        if (root != null && d >= 2) {
            root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }
}
