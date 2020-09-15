package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author az
 * @since 09/15/20
 */
public class ValidateBst {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 采用Long => 避免Integer.MAX_VALUE和MIN_VALUE不够用
     */
    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val)
                && isValidBST(root.right, root.val, maxValue);
    }

    public boolean isValidBst(TreeNode root) {
        // pre order => 递增
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        // 判重
        return list.equals(list.stream().distinct().sorted().collect(Collectors.toList()));
    }

    private void dfs(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(list, node.left);
        list.add(node.val);
        dfs(list, node.right);
    }
}
