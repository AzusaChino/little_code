from typing import List

from common import TreeNode


class Solution:
    def zig_zag(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        res, tmp, stack, flag = [], [], [root], 1
        while stack:
            for i in range(len(stack)):
                cur = stack.pop(0)
                tmp += [cur.val]
                if cur.left: stack += [cur.left]
                if cur.right: stack += [cur.right]
            res += tmp[::flag]
            tmp = []
            flag *= -1
        return res
