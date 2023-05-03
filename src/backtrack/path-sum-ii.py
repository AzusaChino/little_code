# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        ret = []
        track = []

        def backtrack(node, sm, track: List[int]):
            if not node:
                return
            track.append(node.val)
            if node.val == sm and not node.left and not node.right:
                ret.append(track[:])
                return
            backtrack(node.left, sm - node.val, track)
            backtrack(node.right, sm - node.val, track)
            track.pop()

        backtrack(root, targetSum, track)
        return ret
