package cn.az.code.year2021.apr;

import cn.az.code.common.TreeNode;

import java.util.LinkedList;

/**
 * @author az
 * @since 2021-04-11 19:37
 */
public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        int res = 0, i;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            for (i = q.size() - 1, res = 0; i >= 0; --i) {
                TreeNode node = q.poll();
                res += node.val;
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
        }
        return res;
    }
}
