package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @date 5/14/2020
 */
public class DeleteBSTNode {

    public TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = delete(root.right, minNode.val);
            // do delete
        } else if (root.val > val) {
            root.left = delete(root.left, val);
        } else {
            root.right = delete(root.right, val);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
