class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = None
        self.right = None


class Tree:
    def __init__(self):
        self.root = None

    def insert(self, val):
        if self.root:
            node = self.root
            while node:
                if val > node.val:
                    if node.right:
                        node = node.right
                    else:
                        node.right = TreeNode(val)
                        break
                else:
                    if node.left:
                        node = node.left
                    else:
                        node.left = TreeNode(val)
                        break

        else:
            self.root = TreeNode(val)

    def search(self, val):
        if self.root:
            node = self.root
            while node:
                if val > node.val:
                    node = node.right
                elif val < node.val:
                    node = node.left
                else:
                    return node
            return None
        return None

    def deleteNote(self, val):
        pass
