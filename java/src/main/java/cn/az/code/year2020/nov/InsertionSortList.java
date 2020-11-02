package cn.az.code.year2020.nov;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @since 11/02/20
 */
public class InsertionSortList {

    public ListNode sort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (head != null) {
            ListNode temp = head.next;

            if (prev.val >= head.val) {
                prev = dummy;
            }
            while (prev.next != null && prev.next.val < head.val) {
                prev = prev.next;
            }

            head.next = prev.next;
            prev.next = head;
            head = temp;
        }

        return dummy.next;
    }
}
