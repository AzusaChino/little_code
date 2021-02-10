package cn.az.code.year2021.feb;

import java.util.Map;
import java.util.HashMap;

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

    }
}