package cn.az.code.medium;

import cn.az.code.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author : Liz
 * @date : 2019/11/9
 **/
public class TreeTraversal102 {

    public static void main(String[] args) {
        System.out.println(tra(new TreeNode(1)));
    }

    public static List<List<Integer>> tra(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (Objects.isNull(root)) {
            return ret;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (Objects.nonNull(cur.left)) {
                    queue.offer(cur.left);
                }
                if (Objects.nonNull(cur.right)) {
                    queue.offer(cur.right);
                }
            }
            ret.add(list);
        }
        return ret;
    }
}
