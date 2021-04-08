package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 09/15/20
 */
public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (p.val < root.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
