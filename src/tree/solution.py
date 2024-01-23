from typing import List, Optional
from collections import Counter
import itertools


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        c = Counter(nums)
        ret = 0
        for v in c.values():
            if v == 1:
                return -1
            if v % 3 == 0:
                ret += v // 3
            else:
                ret += v // 3 + 1
        return ret

    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        def dfs(node):
            if not node:
                return
            if not node.left and not node.right:
                yield node.val
            yield from dfs(node.left)
            yield from dfs(node.right)

        return all(a == b for a, b in itertools.zip_longest(dfs(root1), dfs(root2)))

    # if subtree does not contain infected node, return maximum depth
    # if subtree contains infected node, return infected node depth (use negative value to distinguish this case)
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        self.ret = 0

        def dfs(node):
            if not node:
                return 0
            l, r = dfs(node.left), dfs(node.right)

            if node.val == start:
                self.ret = max(l, r)
                return -1
            elif l >= 0 and r >= 0:
                return max(l, r) + 1
            else:
                self.ret = max(self.ret, abs(l - r))
                return min(l, r) - 1

        dfs(root)
        return self.ret

    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        def dfs(node, mx, mn):
            if not node:
                return mx - mn
            mx = max(node.val, mx)
            mn = min(node.val, mn)
            return max(dfs(node.left, mx, mn), dfs(node.right, mx, mn))

        return dfs(root, root.val, root.val)

    def halvesAreAlike(self, s: str) -> bool:
        vs = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
        st = set(vs)
        n = len(s)
        lc = rc = 0
        for i in range(n // 2):
            if s[i] in st:
                lc += 1
            if s[n - i - 1] in st:
                rc += 1

        return lc == rc
