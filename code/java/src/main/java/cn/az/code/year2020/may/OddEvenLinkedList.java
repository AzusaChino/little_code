package cn.az.code.year2020.may;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @date 2020/5/17
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head != null) {

            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;

    }
}
