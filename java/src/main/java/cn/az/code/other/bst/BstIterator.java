package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

import java.util.Stack;

/**
 * little-code
 *
 * @author azusachino
 * @since 28/9/2020 07:29
 */
public class BstIterator {

    private final Stack<TreeNode> stack = new Stack<>();

    public BstIterator(TreeNode root) {
        pushAll(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    static class BSTIterator {
        private TreeNode visit;
        private final Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            visit = root;
            stack = new Stack<>();
        }

        public boolean hasNext() {
            return visit != null || !stack.empty();
        }

        public int next() {
            while (visit != null) {
                // push all left
                stack.push(visit);
                visit = visit.left;
            }
            TreeNode next = stack.pop();
            // if there is a right
            visit = next.right;
            return next.val;
        }
    }
}
