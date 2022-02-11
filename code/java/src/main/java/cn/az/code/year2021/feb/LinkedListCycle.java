package cn.az.code.year2021.feb;

import cn.az.code.common.ListNode;

/**
 * @author ycpang
 * @since 2021-02-03 16:01
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
