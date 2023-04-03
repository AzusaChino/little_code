from typing import Optional


class ListNode:
    def __init__(self, val: int, next=None):
        self.val = val
        self.next = next

    def __repr__(self) -> str:
        ret = str(self.val) + " -> "
        nxt = self.next
        while nxt:
            ret += str(nxt.val) + " -> "
            nxt = nxt.next
        return ret


class LinkedList:
    def __init__(self, cap: int):
        self.cap = cap
        # tombstone node
        self.head = ListNode(0)

    def push(self, val):
        hd = self.head
        while hd.next:
            hd = hd.next
        hd.next = ListNode(val)

    def pop(self) -> Optional[int]:
        hd = self.head
        if not hd.next:
            return None
        while hd.next:
            hd = hd.next
        return hd.val


def reverse_linkedlist(head: Optional[ListNode]) -> Optional[ListNode]:
    if not head:
        return None
    prev = None
    while head:
        nxt = head.next
        head.next = prev
        prev = head
        head = nxt
    return prev


if __name__ == '__main__':
    head = ListNode(1, ListNode(2, ListNode(3)))
    print(head)
    print(reverse_linkedlist(head))
