from common import TreeNode


class Solution:
    def recover(self, root: TreeNode):
        self.s1 = None
        self.s2 = None
        self.prev = TreeNode(float('-inf'))
        self.inorder(root)
        self.s1.val, self.s2.val = self.s2.val, self.s1.val

    def inorder(self, node):
        if not node:
            return
        self.inorder(node.left)

        if node.val <= self.prev.val:
            if not self.s1:
                self.s1 = self.prev
            if self.s1:
                self.s2 = node

        self.prev = node
        self.inorder(node.right)
