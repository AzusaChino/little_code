package cn.az.code.year2020.july;

import cn.az.code.common.Node;

/**
 * @author az
 * @since 2020-07-10 23:22
 */
public class FlattenMultiLevelDoublyLinkedList {

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        // Pointer
        Node p = head;
        while (p != null) {
            /* CASE 1: if no child, proceed */
            if (p.child == null) {
                p = p.next;
                continue;
            }
            /* CASE 2: got child, find the tail of the child and link it to p.next */
            Node temp = p.child;
            // Find the tail of the child
            while (temp.next != null) {
                temp = temp.next;
            }
            // Connect tail with p.next, if it is not null
            temp.next = p.next;
            if (p.next != null) p.next.prev = temp;
            // Connect p with p.child, and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}
