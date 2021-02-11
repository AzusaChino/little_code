package cn.az.code.year2021.feb;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author ycpang
 */
public class CopyListWithRandomPointer {

     public Node copyRandomList(Node head) {
        Map<Node, Node> originalToNew = new HashMap<>();
        Node preHead = new Node(0);
        Node current = preHead;
        Node traverse = head;
        while (traverse != null) {
            current.next = new Node(traverse.val);
            current = current.next;
            originalToNew.put(traverse, current);
            traverse = traverse.next;
        }

        for (Node originalNode : originalToNew.keySet()) {
            Node newNode = originalToNew.get(originalNode);
            if (originalNode.random != null) {
                newNode.random = originalToNew.get(originalNode.random);
            }
        }

        return preHead.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int _val) {
            this.val = _val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val && Objects.equals(next, node.next) && Objects.equals(random, node.random);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next, random);
        }
    }
}