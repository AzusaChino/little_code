package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author az
 * @since 09/15/20
 */
public class BstInorderTraverse {

    // 1. recursive
    public List<Integer> traverseRecursive(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(ret, root);
        return ret;
    }

    private void dfs(List<Integer> ret, TreeNode root) {
        if (root == null) {
            return;
        }
        ret.add(root.val);
        dfs(ret, root.left);
        dfs(ret, root.right);
    }

    // 2. stack
    public List<Integer> traverseIterative(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return ret;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ret.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ret;
    }

    /**
     * 1、cur.left 为 null，保存 cur 的值，更新 cur = cur.right
     * <p>
     * 2、cur.left 不为 null，找到 cur.left 这颗子树最右边的节点记做 last
     * <p>
     * 2.1 last.right 为 null，那么将 last.right = cur，更新 cur = cur.left
     * <p>
     * 2.2 last.right 不为 null，说明之前已经访问过，第二次来到这里，表明当前子树遍历完成，保存 cur 的值，更新 cur = cur.right
     *
     * @param root root
     * @return list
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            //情况 1
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else {
                //找左子树最右边的节点
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                //情况 2.1
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                //情况 2.2
                if (pre.right == cur) {
                    //这里可以恢复为 null
                    pre.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}
