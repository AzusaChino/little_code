def getAllElements(self, root1, root2):
    values = []
    def collect(root):
        if root:
            collect(root.left)
            values.append(root.val)
            collect(root.right)
    collect(root1)
    collect(root2)
    return sorted(values)