package cn.az.code.year2020.jun;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 2020-06-15 22:15
 */
public class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
