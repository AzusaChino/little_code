package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author az
 * @since 08/08/20
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    static class PathSum2 {

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ret = new ArrayList<>();
            pathSum(root, sum, new ArrayList<>(), ret);
            return ret;
        }

        public void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> ret) {
            if (root == null) {
                return;
            }
            cur.add(root.val);
            if (root.left == null && root.right == null && root.val == sum) {
                ret.add(new ArrayList<>(cur));
            } else {
                pathSum(root.left, sum - root.val, cur, ret);
                pathSum(root.right, sum - root.val, cur, ret);
            }
            cur.remove(cur.size() - 1);
        }

        public List<List<Integer>> $pathSum(TreeNode root, int sum) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            helper(root, sum, new ArrayList<>(), res);
            return res;
        }

        private void helper(TreeNode node, int sum, List<Integer> list, List<List<Integer>> res) {
            if (node == null) {
                return;
            }
            // 添加到当前的List
            list.add(node.val);
            if (node.left == null && node.right == null && sum == node.val) {
                res.add(new ArrayList<>(list));
            }
            if (node.left != null) {
                list.add(node.val);
                helper(node.left, sum - node.val, list, res);
            }
            if (node.right != null) {
                list.add(node.val);
                helper(node.right, sum - node.val, list, res);
            }
            // back track
            list.remove(list.size() - 1);
        }
    }

    static class PathSum3 {

        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        private int pathSumFrom(TreeNode node, int sum) {
            if (node == null) {
                return 0;
            }
            return (node.val == sum ? 1 : 0)
                    + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
        }
    }
}
