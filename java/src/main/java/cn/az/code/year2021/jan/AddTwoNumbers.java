package cn.az.code.year2021.jan;

import cn.az.code.common.ListNode;

/**
 * @author ycpang
 * @since 2021/1/12 16:19
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 维持链表结构
        ListNode dummy = new ListNode(0);

        // 负责移动的链表节点
        ListNode temp = dummy;

        // 和，进位
        int sum = 0, carry = 10;
        while (l1 != null || l2 != null) {
            // 和大于10，取余数
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
        // 判断最后的和 是否进一了
        if (sum / carry == 1) {
            temp.next = new ListNode(1);
        }
        return dummy.val == 0 ? dummy.next : dummy;

    }
}
