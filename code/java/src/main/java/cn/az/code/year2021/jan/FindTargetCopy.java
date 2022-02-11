package cn.az.code.year2021.jan;

import cn.az.code.common.TreeNode;

/**
 * @author az
 */
public class FindTargetCopy {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) {
            return cloned;
        }
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null) {
            return res;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }

}