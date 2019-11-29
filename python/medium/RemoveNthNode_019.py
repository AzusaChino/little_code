from common import ListNode


def removeNthFromEnd1(head, n):
    def index(node):
        if not node:
            return 0
        i = index(node.next) + 1
        if i > n:
            node.next.val = node.val
        return i

    index(head)
    return head.next


def removeNthFromEnd2(head, n):
    def remove(head):
        if not head:
            return 0, head
        i, head.next = remove(head.next)
        return i + 1, (head, head.next)[i + 1 == n]

    return remove(head)[1]


def removeNthFromEnd3(head, n):
    fast = slow = head
    for _ in range(n):
        fast = fast.next
    if not fast:
        return head.next
    while fast.next:
        fast = fast.next
        slow = slow.next
    slow.next = slow.next.next
    return head


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    print(removeNthFromEnd1(head, 2))
