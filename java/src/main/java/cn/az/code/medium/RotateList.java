package cn.az.code.medium;

import cn.az.code.common.ListNode;

/**
 * @author Liz
 * @date 1/7/2020
 */
public class RotateList {

    public static void main(String[] args) {
        ListNode l = new ListNode(2);
        l.next = new ListNode(3);
        l.next.next = new ListNode(6);
        l.next.next.next = new ListNode(9);
        System.out.println(rotate(l, 3));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode copyHead = head;
        int len = 1;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
            len++;
        }
        //link the tail and head to make it a circle
        copyHead.next = head;
        for (int i = len - k % len; i > 1; i--) {
            head = head.next;
        }
        copyHead = head.next;
        //break the circle
        head.next = null;
        return copyHead;
    }

    public static ListNode rotate(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int size = 1;
        ListNode fast = head, slow = head;

        while (fast.next != null) {
            size++;
            fast = fast.next;
        }

        for (int i = size - k % size; i > 1; i--) {
            slow = slow.next;
        }

        fast.next = head; // link the circle
        head = slow.next; // move the headptr
        slow.next = null; // break the circle(the link before new head)

        return head;
    }
}

