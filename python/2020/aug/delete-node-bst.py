from easy.SameTree import TreeNode


class Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root:
            return root
        if key < root.val:
            root.left = self.deleteNode(root.left, key)
        elif key > root.val:
            root.right = self.deleteNode(root.right, key)
        else:
            if not root.left:
                return root.right
            if not root.right:
                return root.left

            pre = root
            _next = root.right
            while _next.left:
                pre = _next
                _next = _next.left

            root.val = _next.val
            if pre != root:
                pre.left = _next.right
            else:
                pre.right = _next.right

        return root
