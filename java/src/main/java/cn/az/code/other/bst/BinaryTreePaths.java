package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * little-code
 *
 * @author azusachino
 * @since 24/9/2020 00:45
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), root, false);
        return list;
    }

    private void dfs(List<String> list, List<String> cur, TreeNode root, boolean leaf) {
        if (leaf) {
            list.add(String.join("->", cur));
            return;
        }
        if (root == null) {
            return;
        }
        cur.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            dfs(list, cur, null, true);
        } else {
            dfs(list, cur, root.left, false);
            dfs(list, cur, root.right, false);
        }
        cur.remove(cur.size() - 1);
    }
}
