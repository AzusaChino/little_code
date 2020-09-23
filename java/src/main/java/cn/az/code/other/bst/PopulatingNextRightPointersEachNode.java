package cn.az.code.other.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * little-code
 *
 * @author azusachino
 * @since 24/9/2020 00:14
 */
public class PopulatingNextRightPointersEachNode {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        return connect(root.left);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
