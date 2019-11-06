class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def same(p: TreeNode, q: TreeNode):
    if p and q:
        return p.val == q.val and same(p.left, q.left) and same(p.right, q.right)
    return p is q


if __name__ == '__main__':
    p = TreeNode(1)
    q = TreeNode(1)
    print(same(p, q))
