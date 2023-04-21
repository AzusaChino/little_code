from index import TreeNode
import sys


def valid_bst(root: TreeNode) -> bool:
    def compare(node: TreeNode, mi, ma) -> bool:
        if not node:
            return True
        if node.val < mi or node.val > ma:
            return False
        l = compare(node.left, mi, node.val)
        r = compare(node.right, node.val, ma)
        return l and r

    return compare(root, -sys.maxsize, sys.maxsize)
