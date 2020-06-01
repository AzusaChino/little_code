from common import TreeNode


class Solution:

    def invert1(self, root: TreeNode) -> TreeNode:
        if root:
            root.left, root.right = self.invert1(root.right), self.invert1(root.left)
        return root

    def invert2(self, root: TreeNode) -> TreeNode:
        stack = [root]
        while stack:
            node = stack.pop()
            if node:
                node.left, node.right = node.right, node.left
                stack += node.left, node.right
        return root
