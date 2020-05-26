import bisect

from common import TreeNode


class Solution:
    def bst_from_preorder(self, A):
        if not A: return None
        root = TreeNode(A[0])
        i = bisect.bisect(A, A[0])
        root.left = self.bst_from_preorder(A[1:i])
        root.right = self.bst_from_preorder(A[i:])
        return root


def bst_from_pre_order(A):
    def helper(i, j):
        if i == j:
            return None
        root = TreeNode(A[i])
        mid = bisect.bisect(A, A[i], i + 1, j)
        root.left = helper(i + 1, mid)
        root.right = helper(mid, j)
        return root

    return helper(0, len(A))
