package cn.az.code.year2020.nov;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author az
 * @since 11/13/20
 */
public class PopulatingNextRightPointersEachNode {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty() && q.peek() != null) {
            Queue<Node> nextQueue = new LinkedList<>();
            Node prev = null;
            for (Node node : q) {
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;

                nextQueue.offer(node.left);
                nextQueue.offer(node.right);
            }
            q = nextQueue;
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


}
