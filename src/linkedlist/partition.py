class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def partition(head: ListNode, val: int):
    if not head:
        return None
    l1 = ListNode()
    l2 = ListNode()
    l1t = l1
    l2t = l2
    while head:
        if head.val < val:
            l1t.next = head
            l1t = l1t.next
        else:
            l2t.next = head
            l2t = l2t.next
        t = head.next
        head.next = None
        head = t
    return l1.next
