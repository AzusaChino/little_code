#
# @lc app=leetcode id=61 lang=python3
#
# [61] Rotate List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if not head:
            return None
        fast, slow = head, head
        size = 1
        # for fast.next = head
        while fast.next:
            size += 1
            fast = fast.next
        for _ in range(1, (size - k % size), -1):
            slow = slow.next
        fast.next = head
        head = slow.next
        slow.next = None
        return head
# @lc code=end

