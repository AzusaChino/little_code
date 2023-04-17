import heapq
from typing import List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def mergeKLists(lists: List[ListNode]) -> ListNode:
    if not list:
        return None
    pq = []
    for l in list:
        heapq.heappush(pq, (l.val, l))

    dummy = tail = ListNode(0)
    while pq:
        _, tail.next = heapq.heappop()
        tail = tail.next

        if tail.next:
            heapq.heappush(pq, (tail.next.val, tail.next))

    return dummy.next
