package cn.az.code.common;

import lombok.Data;

/**
 * @author Liz
 * @date 2019/10/20
 **/
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }


    public static ListNode forSimpleTest(int... nums) {
        ListNode head = new ListNode(0);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int n : nums) {
            head.next = new ListNode(n);
            head = head.next;
        }
        return dummy.next;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode that = this;
        while (that != null) {
            res.append(that.val).append(" -> ");
            that = that.next;
        }
        return res.toString();
    }
}
