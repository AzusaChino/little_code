package cn.az.code.year2021.july;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 2021-07-23
 */
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0)
            return null;
        return root;
    }
}
