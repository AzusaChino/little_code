from common import ListNode


def rotate_list(head: ListNode, k: int) -> ListNode:
    n, pre, cur = 0, None, head
    while cur:
        pre, cur = cur, cur.next
        n += 1
    if not n or k % n:
        return head
    tail = head
    for _ in range(n - k % n - 1):
        tail = tail.next
    nxt, tail.next, pre.next = tail.next, None, head
    return nxt
