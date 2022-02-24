#
# @lc app=leetcode id=141 lang=python3
#
# [141] Linked List Cycle
#
# 1. 暴力: 遍历链表, hash/set记录
# 2. 快慢指针 
# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if not head: return False
        save = set()
        cur = head
        while cur:
            if cur in save: return True
            save.add(cur)
            cur = cur.next
        return False
    def hasCycle2(self, head: ListNode) -> bool:
        try:
            slow = head
            fast = head.next
            while slow is not fast:
                slow = slow.next
                fast = fast.next.next
            return True
        except:
            return False
# @lc code=end

