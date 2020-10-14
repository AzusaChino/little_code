package cn.az.code.year2020.april;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @since 10/14/20
 */
public class MiddleLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
