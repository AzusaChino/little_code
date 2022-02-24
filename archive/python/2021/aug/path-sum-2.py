from common import TreeNode
from typing import List


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        rst = []
        self._dfs(root, sum, rst, [])
        return rst

    def _dfs(self, root, sum, rst, path):
        if not root:
            return

        # add current root's value to the path
        path.append(root.val)

        # in case this is a leaf node
        if not root.left and not root.right:
            if not sum - root.val:
                # for primitive values, [:] is sufficient (although it is doing shallow copy)
                rst.append(path[:])
        else:
            self._dfs(root.left, sum - root.val, rst, path)
            self._dfs(root.right, sum - root.val, rst, path)

        # backtrack
        path.pop()
