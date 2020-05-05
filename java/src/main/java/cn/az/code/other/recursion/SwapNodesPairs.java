package cn.az.code.other.recursion;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @date 5/4/2020
 */
public class SwapNodesPairs {

    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null)) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
