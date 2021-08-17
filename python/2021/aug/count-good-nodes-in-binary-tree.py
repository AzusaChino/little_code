class Solution:
    def goodNodes(self, r, ma=-10000):
        return (
            self.goodNodes(r.left, max(ma, r.val))
            + self.goodNodes(r.right, max(ma, r.val))
            + (r.val >= ma)
            if r
            else 0
        )
