package cn.az.code.year2021.feb;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author ycpang
 * @since 2021-02-06 16:59
 */
public class BinaryTreeRightSideView {

    // 利用队列层级遍历, 每次取最后一个即可

    public List<Integer> rightSideView(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                assert node != null;
                if (i == size - 1) {
                    ret.add(node.val);
                }
                if (Objects.nonNull(node.left)) {
                    q.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    q.offer(node.right);
                }
            }
        }
        return ret;
    }
}
