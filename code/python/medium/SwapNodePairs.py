from common import ListNode


def swap_pairs(head: ListNode) -> ListNode:
    """
    :type head: ListNode
    :rtype: ListNode
    """
    # Dummy node acts as the prevNode for the head node
    # of the list and hence stores pointer to the head node.
    dummy = ListNode(-1)
    dummy.next = head

    prev_node = dummy

    while head and head.next:
        # Nodes to be swapped
        first_node = head
        second_node = head.next

        # Swapping
        prev_node.next = second_node
        first_node.next = second_node.next
        second_node.next = first_node

        # Reinitializing the head and prev_node for next swap
        prev_node = first_node
        head = first_node.next

    # Return the new head node.
    return dummy.next


class Solution(object):
    def swapPairs(self, head: ListNode) -> ListNode:
        """
        :type head: ListNode
        :rtype: ListNode
        """

        # If the list has no node or has only one node left.
        if not head or not head.next:
            return head

        # Nodes to be swapped
        first_node = head
        second_node = head.next

        # Swapping
        first_node.next = self.swapPairs(second_node.next)
        second_node.next = first_node

        # Now the head is the second node
        return second_node
