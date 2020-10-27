package cn.az.code.year2020.oct;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @since 10/28/20
 */
public class LinkedListCycle2 {

    public ListNode hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head, slow = head, start = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // find cycle
            if (slow == fast) {
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        // no cycle
        return null;
    }
}
