package cn.az.code.other.linkedlist;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @since 2020-07-06 23:30
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();

        System.out.println(rl.reverse(ListNode.forSimpleTest(1, 2, 3, 4, 5)));
    }

    public ListNode reverseList(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode _reverseList(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    private ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
