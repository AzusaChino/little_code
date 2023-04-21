from index import ListNode


def reverse_k_group(head: ListNode, k: int) -> ListNode:
    def reverse_range(a: ListNode, b: ListNode) -> ListNode:
        new_head = None
        cur = a
        while cur != b:
            nxt = cur.next
            cur.next = new_head
            new_head = cur
            cur = nxt
        return new_head

    if not head:
        return head
    a = b = head
    for _ in range(k):
        if not b:
            return head
        b = b.next
    new_head = reverse_range(a, b)
    a.next = reverse_k_group(b, k)
    return new_head
