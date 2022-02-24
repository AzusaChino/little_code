package cn.az.code.practices.bst;

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
        dfs(list, new ArrayList<>(), root);
        return list;
    }

    private void dfs(List<String> list, List<String> cur, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(String.join("->", cur));
            return;
        }

        cur.add(String.valueOf(root.val));
        if (root.left != null) {
            dfs(list, cur, root.left);
        }
        if (root.right != null) {
            dfs(list, cur, root.right);
        }
        cur.remove(cur.size() - 1);
    }
}
