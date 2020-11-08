package cn.az.code.year2020.nov;

import cn.az.code.common.ListNode;

import java.util.Stack;

/**
 * @author az
 * @since 11/08/20
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode ret = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                carry += s1.pop();
            }
            if (!s2.isEmpty()) {
                carry += s2.pop();
            }
            ret.val = carry % 10;
            ListNode head = new ListNode(carry / 10);
            head.next = ret;
            ret = head;
            carry /= 10;
        }

        return ret.val == 0 ? ret.next : ret;
    }
}
