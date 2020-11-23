from common import TreeNode


class Solution:
    def rob(self, root: TreeNode) -> int:
        return max(self.helper(root))

    def helper(self, root):
        if not root:
            return 0, 0
        l1, l0 = self.helper(root.left)
        r1, r0 = self.helper(root.right)

        m1 = root.val + l0 + r0
        m0 = max(l1, l0) + max(r1, r0)
        return m1, m0
