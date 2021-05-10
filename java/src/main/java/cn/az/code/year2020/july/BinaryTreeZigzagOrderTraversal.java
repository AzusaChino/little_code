package cn.az.code.year2020.july;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author az
 * @since 07/22/20
 */
public class BinaryTreeZigzagOrderTraversal {

    public List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;

        while (!q.isEmpty()) {
            int size = q.size();
            flag = !flag;
            List<Integer> tmp = new ArrayList<>();

            while (size > 0) {
                size--;
                TreeNode cur = q.poll();
                if (flag) {
                    tmp.add(cur.val);
                } else {
                    tmp.add(0, cur.val);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
