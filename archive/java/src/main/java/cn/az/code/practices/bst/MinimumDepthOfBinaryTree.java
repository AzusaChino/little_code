package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * little-code
 *
 * @author azusachino
 * @since 24/9/2020 23:32
 */
public class MinimumDepthOfBinaryTree {

    // bfs

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return step;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            step++;
        }
        return step;

    }


    // dfs

    private int min = Integer.MAX_VALUE;

    public int minD(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return min;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // find leaf
        if (root.left == null && root.right == null) {
            min = Math.min(min, depth);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
