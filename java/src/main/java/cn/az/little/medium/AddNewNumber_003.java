package cn.az.little.medium;

import cn.az.little.common.ListNode;

/**
 * @author : Liz
 * @date : 2019/10/20
 **/
public class AddNewNumber_003 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(function(l1, l2));
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
}
