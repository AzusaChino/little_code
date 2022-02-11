package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author az
 * @since 09/09/20
 */
public class MaxHeight {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        MaxHeight mh = new MaxHeight();
        System.out.println(mh.maxHeightBfs(root));
        System.out.println(mh.maxHeightDfs(root));
    }

    public int maxHeightBfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 计算root的层
        int level = 1;
        int maxLevel = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                assert cur != null;
                // 最后一层 -> 仅有一个子节点
                if (cur.left == null && cur.right == null) {
                    maxLevel = Math.max(level, maxLevel);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            level++;
        }
        return maxLevel;
    }

    public int maxHeightDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxHeightDfs(root.left), maxHeightDfs(root.right));
    }

}
