package cn.az.code.year2021.aug;

import cn.az.code.common.TreeNode;
import java.util.HashSet;

/**
 * @author az
 * @since 2021-08-23
 */
public class TwoSum4 {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
}
