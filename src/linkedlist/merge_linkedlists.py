import heapq
from typing import List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def mergeKLists(lists: List[ListNode]) -> ListNode:
    if not lists:
        return None
    pq = []
    for l in lists:
        heapq.heappush(pq, (l.val, l))

    dummy = tail = ListNode(0)
    while pq:
        _, tail.next = heapq.heappop(pq)
        tail = tail.next

        if tail.next:
            heapq.heappush(pq, (tail.next.val, tail.next))

    return dummy.next


def mergeKDummy(lists: List[ListNode]) -> ListNode:
    huge = []
    for head in lists:
        node = head
        while node:
            huge.append(node)
            node = node.next
    # collect all & sort
    huge.sort(key=lambda x: x.val)
    cursive = dummy = ListNode(0)

    for n in huge:
        cursive.next = n
        cursive = cursive.next

    return dummy.next


if __name__ == "__main__":
    lists = [ListNode(1), ListNode(0, ListNode(2))]
    head = mergeKLists(lists)
    while head:
        print(head.val)
        head = head.next
