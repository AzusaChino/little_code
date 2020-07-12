package cn.az.code.year2020.july;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 2020-07-09 20:48
 */
public class MaximumWidthBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> lefts = new ArrayList<>();
        return _dfs(root, 1, 0, lefts);
    }

    private int _dfs(TreeNode n, int id, int d, List<Integer> lefts) {
        if (n == null) return 0;
        if (d >= lefts.size()) lefts.add(id);
        return Math.max(id + 1 - lefts.get(d), Math.max(_dfs(n.left, id * 2, d + 1, lefts), _dfs(n.right, id * 2 + 1, d + 1, lefts)));
    }
}
