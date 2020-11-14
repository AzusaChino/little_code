class TreeLinkNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


class Solution:
    @staticmethod
    def connect(root: TreeLinkNode):
        level = [root]
        while level and level[0]:
            next_level = []
            prev = None
            for node in level:
                if prev:
                    prev.next = node
                prev = node

                next_level.append(node.left)
                next_level.append(node.right)

            level = next_level
