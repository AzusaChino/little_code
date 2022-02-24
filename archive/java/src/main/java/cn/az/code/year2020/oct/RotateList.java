package cn.az.code.year2020.oct;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @since 10/09/20
 */
public class RotateList {

    public ListNode rotate(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++) {
            fast = fast.next;
        }

        for (int j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode newHead, tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k %= len;
        tail.next = head;
        for (int i = 0; i < len - k; i++) {
            tail = tail.next;
        }
        newHead = tail.next;
        tail.next = null;
        return newHead;
    }
}
