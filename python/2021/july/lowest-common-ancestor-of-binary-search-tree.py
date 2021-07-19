class Solution:
    def lowestCommonAncestor(self, root, p, q):
        next = (
            p.val < root.val > q.val
            and root.left
            or p.val > root.val < q.val
            and root.right
        )
        return self.lowestCommonAncestor(next, p, q) if next else root
