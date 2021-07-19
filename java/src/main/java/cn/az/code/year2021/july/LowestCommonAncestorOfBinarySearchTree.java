package cn.az.code.year2021.july;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 2021-07-19
 */
public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }

}
