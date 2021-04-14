package cn.az.code.year2021.apr;

import cn.az.code.common.ListNode;

/**
 * @author ycpang
 * @since 2021-04-14 16:24
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode node1 = new ListNode(0), node2 = new ListNode(0);
        ListNode n1 = node1, n2 = node2;

        while (head != null) {
            if (head.val < x) {
                n1 = n1.next = head;
            } else {
                n2 = n2.next = head;
            }
            head = head.next;
        }
        n1.next = node2.next;
        n2.next = null;
        return node1.next;
    }
}
