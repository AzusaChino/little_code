package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * little-code
 *
 * @author azusachino
 * @since 24/9/2020 00:24
 */
public class BinarySearchTreeIterator {

    private final Queue<Integer> stack;

    // q: how to keep O(h) space

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new LinkedList<>();
        dfs(root);
    }

    /** @return the next smallest number */
    public int next() {
        return stack.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty();
    }

    private void dfs(TreeNode root) {
        dfs(root.left);
        stack.add(root.val);
        dfs(root.right);
    }
}
