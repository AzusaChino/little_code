package cn.az.code;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @date 2020/4/17
 */
public class Test {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode fast = head, slow = head;

        while (fast.next != null) {
            fast = fast.next;
            System.out.println(fast);
        }

        fast.next = head;
        System.out.println(fast);
        System.out.println(head);
    }
}
