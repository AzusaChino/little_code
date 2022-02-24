package cn.az.code.year2020.july;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 2020-07-13 23:30
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            return p == q;
        }
        if(p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
