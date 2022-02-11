package cn.az.code.year2020.oct;

import cn.az.code.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author az
 * @since 10/09/20
 */
public class SerializeDeserializeBst {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        dfs(root, sb);

        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    public TreeNode deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Queue<String> q = new LinkedList<>(Arrays.asList(s.split(",")));
        return helper(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(Queue<String> q, int minValue, int maxValue) {
        if (q.isEmpty()) {
            return null;
        }
        int val = Integer.parseInt(q.peek());
        if (val < minValue || val > maxValue) {
            return null;
        }
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = helper(q, minValue, val);
        root.right = helper(q, val, maxValue);
        return root;
    }
}
