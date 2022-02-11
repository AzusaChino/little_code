package cn.az.code.medium;

import cn.az.code.common.ListNode;

import java.util.Stack;

/**
 * @author az
 * @date 2020/4/17
 */
public class AddTwoNumber {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumber a2 = new AddTwoNumber();
        System.out.println(a2.addTwoNumber(l1, l2));
    }

    private static ListNode function(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        // 用于循环next
        ListNode temp = result;
        int sum = 0;
        int carry = 10;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        if (sum / carry == 1) {
            temp.next = new ListNode(1);
        }
        return result.val == 0 ? result.next : result;
    }
    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();

        // stack for reverse order
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        // final result
        ListNode result = null;
        // add result is over 10
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            if (!s1.isEmpty()) {
                carry += s1.pop();
            }
            if (!s2.isEmpty()) {
                carry += s2.pop();
            }
            // 7 ->  => 0 -> 7 ->  => 8 -> 0 -> 7  => 7 -> 8 -> 0 -> 7
            // current value always the last
            ListNode dummy = new ListNode(carry % 10);
            dummy.next = result;
            result = dummy;
            carry /= 10;
        }
        return result;
    }
}
