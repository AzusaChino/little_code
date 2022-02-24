package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 09/08/20
 */
public class SmallestStringStartingFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        return helper(root);
    }

    public String helper(TreeNode root) {
        if (root != null) {
            String l = helper(root.left);
            String r = helper(root.right);
            if (l.length() > 0 && r.length() > 0) {
                return (((l.compareTo(r) < 0) ? l : r) + (char) (root.val + 'a'));
            } else if (l.length() > 0) {
                return l + (char) (root.val + 'a');
            } else {
                return r + (char) (root.val + 'a');
            }
        }
        return "";
    }
}
