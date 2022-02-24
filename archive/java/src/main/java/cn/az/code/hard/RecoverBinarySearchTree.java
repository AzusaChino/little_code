package cn.az.code.hard;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @date 2/1/2020
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        RecoverBinarySearchTree r = new RecoverBinarySearchTree();
        r.recoverTree(null);
    }

    private TreeNode first;
    private TreeNode second;
    private TreeNode pre;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        first = null;
        second = null;
        pre = null;
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);

        if (first == null && (pre == null || pre.val >= root.val)) {
            first = pre;
        }
        if (first != null && pre.val >= root.val) {
            second = root;
        }
        pre = root;
        inOrder(root.right);
    }
}
