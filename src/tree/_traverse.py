from collections import deque


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def traverse(root: TreeNode):
    def helper(node, ret):
        if not node:
            return
        ret.append(node.val)
        helper(node.left, ret)
        helper(node.right, ret)

    ret = []
    helper(root, ret)
    return ret


def traverse_iter_preorder(root: TreeNode):
    if not root:
        return
    ret = []
    st = [root]
    while st:
        node = st.pop()
        ret.append(node.val)
        # first in, last out
        if node.right:
            st.append(node.right)
        if node.left:
            st.append(node.left)
    return ret


def traverse_iter_inorder(root: TreeNode):
    res = []
    stack = []
    while root or stack:
        while root:
            stack.append(root)
            root = root.left
        root = stack.pop()
        res.append(root.val)
        root = root.right
    return res


if __name__ == "__main__":
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    print(traverse(root))
    print(traverse_iter_preorder(root))
    print(traverse_iter_inorder(root))
