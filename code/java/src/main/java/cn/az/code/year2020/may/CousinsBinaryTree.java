package cn.az.code.year2020.may;

import cn.az.code.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author az
 * @date 2020/5/8
 */
public class CousinsBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAexist = false;
            boolean isBexist = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == x) {
                    isAexist = true;
                }
                if (cur.val == y) {
                    isBexist = true;
                }
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == x && cur.right.val == y) {
                        return false;
                    }
                    if (cur.left.val == y && cur.right.val == x) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (isAexist && isBexist) {
                return true;
            }
        }
        return false;
    }


}
