package cn.az.code.medium;

import cn.az.code.common.ListNode;

/**
 * @author Liz
 * @date 1/21/2020
 */
public class PartitionList086 {

    public static void main(String[] args) {
        ListNode head = ListNode.forSimpleTest(9,8,5,1,2,3,4);
        PartitionList086 p = new PartitionList086();
        System.out.println("p.partition(head,3) = " + p.partition(head,3));
    }
    
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
        ListNode smaller = smallerHead, bigger = biggerHead;
        while (head != null) {
            if (head.val < x) {
                smaller = smaller.next = head;
            } else {
                bigger = bigger.next = head;
            }
            head = head.next;
        }
        smaller.next = biggerHead.next;
        bigger.next = null;
        return smallerHead.next;
    }
}
