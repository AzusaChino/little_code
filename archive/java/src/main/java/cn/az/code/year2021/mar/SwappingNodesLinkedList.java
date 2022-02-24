package cn.az.code.year2021.mar;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @since 03/14/21 20:29
 */
public class SwappingNodesLinkedList {

    // Put slow at head, and put fast k-1 nodes after slow.
    // first = fast.
    // If fast isn't already at the last node, move slow and fast one node further until fast.next == null
    // second = slow
    // Swap the values of first and second

    public ListNode swapNodes(ListNode head, int k) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode first, second;

        // Put fast (k-1) nodes after slow
        for (int i = 0; i < k - 1; ++i) {
            fast = fast.next;
        }

        // Save the node for swapping
        first = fast;

        // Move until the end of the list
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Save the second node for swapping
        // Note that the pointer second isn't necessary: we could use slow for swapping as well
        // However, having second improves readability
        second = slow;

        // Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}
