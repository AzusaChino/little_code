#
# @lc app=leetcode id=725 lang=python3
#
# [725] Split Linked List in Parts
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def splitListToParts(self, root: ListNode, k: int) -> List[ListNode]:
        cur, l = root, 0
        while cur:
            cur, l = cur.next, l+1
        chunk_size, longer_chunks = l // k , l % k # for 11 & 3 => 3, 2
        res = [chunk_size + 1] * longer_chunks + [chunk_size] * (k-longer_chunks)
        pre, cur = None, root
        for i, n in enumerate(res):
            if pre:
                pre.next = None
            res[i] = cur
            for j in range(n):
                pre, cur = cur, cur.next
        return res

# @lc code=end

