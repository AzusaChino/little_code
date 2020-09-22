class Solution:
    def flatten(self, root):
        cur = root
        while cur:
            if cur.left:
                last = cur.left
                while last.right:
                    last = last.right
                last.right = cur.right
                cur.right = cur.left
                cur.left = None
            cur = cur.right

class Solution2:
    def __init__(self):
        self.prev = None
    
    def flatten(self, root):
        if not root:
            return None
        self.flatten(root.right)
        self.flatten(root.left)
    
        root.right = self.prev
        root.left = None
        self.prev = root
