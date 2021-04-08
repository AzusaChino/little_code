package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author az
 * @since 09/09/20
 */
public class MinHeight {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        MinHeight mh = new MinHeight();
        System.out.println(mh.minHeightBfs(root));
        System.out.println(mh.minHeightDfs(root));
    }

    public int minHeightBfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 计算root的层
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                assert cur != null;
                if (cur.left == null && cur.right == null) {
                    return level;
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
        return -1;
    }

    public int minHeightDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minHeightDfs(root.left);
        int right = minHeightDfs(root.right);
        return (left == 0 || right == 0) ?
                left + right + 1 : Math.min(left, right) + 1;
    }

}
