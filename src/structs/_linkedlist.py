

def rev_str(head) -> bool:
    fast = head
    slow = head
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
    prev = None
    while slow:
        cur = slow
        cur.next = prev
        prev = cur
        slow = slow.next
    while prev:
        if prev.val != head.val:
            return False
        prev = prev.next
        head = head.next
    return True
