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


NULL = "#"
DELI = ","


def level_traverse(root: TreeNode) -> str:
    if not root:
        return ""
    string = []
    q = deque()
    q.append(root)

    while q:
        sz = len(q)
        for _ in range(sz):
            node = q.popleft()
            if not node:
                string.append(NULL)
                string.append(DELI)
                continue

            string.append(str(node.val))
            string.append(DELI)

            q.append(node.left)
            q.append(node.right)

    return "".join(string)


def level_order_de(s: str) -> TreeNode:
    if not s:
        return None
    ss = s.split(DELI)
    root = TreeNode(int(ss[0]))
    q = deque()
    q.append(root)

    i = 1
    while i < len(ss):
        p = q.popleft()
        l = ss[i]
        i += 1
        if l == NULL:
            p.left = None
        else:
            p.left = TreeNode(int(l))
            q.append(p.left)

        r = ss[i]
        i += 1
        if r == NULL:
            p.right = None
        else:
            p.right = TreeNode(int(r))
            q.append(p.right)
    return root


if __name__ == "__main__":
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    print(traverse(root))
    print(traverse_iter_preorder(root))
    print(traverse_iter_inorder(root))
    print(level_traverse(root))
