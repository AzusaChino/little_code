package cn.az.code.year2021.jan;

import cn.az.code.common.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author ycpang
 * @since 2021/1/5 18:55
 */
public class RemoveDuplicateFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

}
