class ListNode:
    def __init__(self, x):
        self.x = x
        self.next = next

    def __str__(self):
        that = self
        s = ''
        while that is not None:
            s += str(that.x)
            that = that.next
        return s


def remove(head: ListNode) -> ListNode:
    cur = head
    while cur:
        while cur.next and cur.next.x == cur.x:
            cur.next = cur.next.next  # skip duplicated node
        cur = cur.next  # not duplicate of current node, move to next node
    return head


if __name__ == '__main__':
    l = ListNode(1)
    l.next = ListNode(2)
    l.next.next = ListNode(2)
    print(remove(l))
