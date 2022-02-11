package cn.az.code.year2020.aug;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @since 08/20/20
 */
public class ReorderList {

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();
        ListNode root = ListNode.forSimpleTest(1, 2, 3, 4, 5, 6);
        System.out.println(root);
        rl.reorderList(root);

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. reverse the 2nd half
        ListNode l2 = reverse(slow);

        // step 3. merge the two halves
        merge(head, l2);
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null) {
                break;
            }

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}
