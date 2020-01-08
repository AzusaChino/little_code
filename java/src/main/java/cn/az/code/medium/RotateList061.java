package cn.az.code.medium;

import cn.az.code.common.ListNode;

/**
 * @author Liz
 * @date 1/7/2020
 */
public class RotateList061 {

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
}

