from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        cur = head
        while cur:
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt
        return prev

    def hasCycle(self, head: ListNode) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False

    def mergeTwoLists(self, list1: ListNode, list2: ListNode) -> ListNode:
        dummy = cur = ListNode(-1)
        while list1 and list2:
            if list1.val >= list2.val:
                cur.next = list2
                list2 = list2.next
            else:
                cur.next = list1
                list1 = list1.next
            cur = cur.next
        cur.next = list1 or list2

        return dummy.next

    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if not head or not k:
            return head
        # calc length, iterate to the last element
        last, L = head, 1
        while last.next:
            L += 1
            last = last.next
        # make a cycle
        last.next = head
        for _ in range(L - k % L):
            last = last.next
        ret = last.next
        # break cycle
        last.next = None
        return ret

    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        if fast and fast.next:
            return slow.next
        return slow

    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        while cur:
            if cur.next and cur.val == cur.next.val:
                cur.next = cur.next.next
            cur = cur.next
        return head

    def isPalindrome(self, head):
        rev = None
        slow = fast = head
        while fast and fast.next:
            fast = fast.next.next
            rev, rev.next, slow = slow, rev, slow.next
        if fast:
            slow = slow.next
        while rev and rev.val == slow.val:
            slow = slow.next
            rev = rev.next
        return not rev


def rev(head: ListNode) -> ListNode:
    if not head or not head.next:
        return head
    last = rev(head.next)
    head.next.next = head
    head.next = None
    return last


def reverse_k(head: ListNode, k: int) -> ListNode:
    a, b = head, head
    for i in range(k):
        if not b:
            return head
        b = b.next
    new_head = reverse_not_change_head(a, b)
    a.next = reverse_k(b, k)
    return new_head


def reverse_not_change_head(a: ListNode, b: ListNode) -> ListNode:
    prev = None
    cur = a
    while cur != b:
        nxt = cur.next
        cur.next = prev
        prev = cur
        cur = nxt
    return prev


if __name__ == "__main__":
    s = Solution()
    head = ListNode(2)
    head.next = ListNode(0)
    head.next.next = ListNode(1)
    print(s.rotateRight(head, 5))
