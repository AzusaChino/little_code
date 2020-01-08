package cn.az.code.medium;

import cn.az.code.common.ListNode;

/**
 * @author Liz
 * @version 2019/12/2
 */
public class SwapNodePairs024 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new SwapNodePairs024().swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int i=0;
        while(dummy.next != null) {
            dummy = dummy.next;
            i++;
            if (i % 2 == 0){
                continue;
            }
            if(dummy.next != null) {
                int temp = dummy.val;
                dummy.val = dummy.next.val;
                dummy.next.val = temp;
            }
        }
        return head;
    }
}
