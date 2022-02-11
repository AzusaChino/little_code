package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @date 5/14/2020
 */
public class InsertIntoBST {

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insert(root.right, val);
        }
        if (root.val > val) {
            root.left = insert(root.left, val);
        }
        return root;
    }
}
