from common import ListNode


def remove_elements(head: ListNode, val: int):
    if head is None:
        return None
    head.next = remove_elements(head.next, val)
    return head.next if head.val == val else head
