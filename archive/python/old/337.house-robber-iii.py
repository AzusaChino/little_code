#
# @lc app=leetcode id=337 lang=python3
#
# [337] House Robber III
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rob(self, root: TreeNode) -> int:
        res = self.dp(root)
        return max(res[0], res[1])
    def dp(self, root:TreeNode) -> List[int]:
        if not root:
            return [0,0]
        l = self.dp(root.left)
        r = self.dp(root.right)
        rob = root.val + l[0] + r[0]
        not_rob = max(l[0], l[1]) + max(r[0], r[1])
        return [not_rob, rob]
# @lc code=end

