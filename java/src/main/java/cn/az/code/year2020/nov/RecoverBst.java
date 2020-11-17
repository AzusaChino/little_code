package cn.az.code.year2020.nov;

import cn.az.code.common.TreeNode;

import java.util.Objects;

/**
 * @author az
 * @since 11/17/20
 */
public class RecoverBst {

    private TreeNode s1;
    private TreeNode s2;

    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recover(TreeNode root) {
        inOrder(root);
        int temp = s1.val;
        s1.val = s2.val;
        s2.val = temp;
    }

    public void inOrder(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        inOrder(node.left);
        if (node.val <= prev.val) {
            if (Objects.isNull(s1)) {
                s1 = prev;
            } else {
                s2 = node;
            }
        }
        prev = node;
        inOrder(node.right);
    }
}
