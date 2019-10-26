class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


def merge(l1: ListNode, l2: ListNode) -> ListNode:
    if l1 is None:
        return l2
    if l2 is None:
        return l1
    if l1.val > l2.val:
        l2.next = merge(l1, l2.next)
        return l2
    else:
        l1.next = merge(l1.next, l2)
        return l1


if __name__ == '__main__':
    print(merge(ListNode(2), ListNode(1)))
