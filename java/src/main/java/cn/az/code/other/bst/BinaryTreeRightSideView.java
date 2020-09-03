package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

import java.util.*;

/**
 * @author az
 * @since 09/03/20
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        BinaryTreeRightSideView bt = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(bt.rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                assert cur != null;
                if (i == 0) {
                    ret.add(cur.val);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
            }
        }
        return ret;
    }
}
