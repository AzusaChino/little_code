package cn.az.code.year2020.oct;

import cn.az.code.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author az
 * @since 10/22/20
 */
public class MinHeightTree {

    public int minHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return height;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            height++;
        }
        return -1;
    }
}
