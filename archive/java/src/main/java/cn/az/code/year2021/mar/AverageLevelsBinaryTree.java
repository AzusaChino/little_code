package cn.az.code.year2021.mar;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author ycpang
 * @since 2021-03-05 17:14
 */
public class AverageLevelsBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Double> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            // 用长整型保存count => overflow
            long count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                count += node.val;
                if (Objects.nonNull(node.left)) {
                    q.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    q.offer(node.right);
                }
            }
            list.add((double) count / size);
        }
        return list;
    }

}
