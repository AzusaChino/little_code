package cn.az.code.year2020.jun;

import cn.az.code.common.ListNode;

public class DeleteNodeLinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
