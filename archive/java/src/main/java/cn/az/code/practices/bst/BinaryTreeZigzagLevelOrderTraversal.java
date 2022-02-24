package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 09/15/20
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        dfs(ret, root, 0);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (ret.size() <= level) {
            ret.add(new ArrayList<>());
        }
        List<Integer> cur = ret.get(level);
        // 根据奇偶判断所在层
        if ((level & 1) == 0) {
            // 正序添加
            cur.add(root.val);
        } else {
            // 反序添加
            cur.add(0, root.val);
        }
        dfs(ret, root.left, level + 1);
        dfs(ret, root.right, level + 1);
    }
}
