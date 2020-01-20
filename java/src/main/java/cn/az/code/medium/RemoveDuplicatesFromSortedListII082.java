package cn.az.code.medium;

import cn.az.code.common.ListNode;
import cn.hutool.core.map.MapUtil;

import java.util.Map;

/**
 * @author Liz
 * @date 1/20/2020
 */
public class RemoveDuplicatesFromSortedListII082 {

    public static void main(String[] args) {
        ListNode head = ListNode.forSimpleTest(1, 1, 2, 3, 4);
        RemoveDuplicatesFromSortedListII082 r = new RemoveDuplicatesFromSortedListII082();
        System.out.println("r.deleteDup(head) = " + r.deleteDuplicate(head));
    }

    public ListNode deleteDup(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDup(head.next);
            return head;
        } else {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDup(head.next);
        }
    }

    public ListNode deleteDuplicate(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, Integer> map = MapUtil.newHashMap();

        while (head.next != null) {
            Integer key = head.val;
            if (map.containsKey(key)) {
                map.compute(key, (k, v) -> v + 1);
            } else {
                map.put(key, 1);
            }
            head = head.next;
        }
        while (dummy.next != null) {
            Integer key = dummy.val;
            if (map.get(key) > 1) {
                dummy.next = dummy.next.next;
            }
            dummy = dummy.next;
        }
        return dummy.next;
    }
}
