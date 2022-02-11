package cn.az.code.practices.design;

import cn.az.code.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author az
 * @since 10/09/20
 */
public class SerializeDeserializeTree {

    public static void main(String[] args) {
        SerializeDeserializeTree sdt = new SerializeDeserializeTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String s = sdt.serialize(root);
        System.out.println(s);
        TreeNode t = sdt.deserialize(s);
        System.out.println(s.equals(sdt.serialize(t)));

    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(q);
    }

    private TreeNode helper(Queue<String> q) {
        if (q.isEmpty() || "#".equals(q.peek())) {
            q.poll();
            return null;
        }

        int val = Integer.parseInt(q.peek());

        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }

}
