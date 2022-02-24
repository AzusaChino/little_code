from collections import namedtuple


class Solution:
    def substree_with_all_deepest(self, root):
        Result = namedtuple('Result', ["node", "depth"])
        def helper(node):
            if not node:
                return Result(None, -1)
            l_r, r_r = helper(node.left), helper(node.right)
            depth_diff = l_r.depth-r_r.depth
            if depth_diff == 0:
                return Result(node, l_r.depth+1)
            if depth_diff > 0:
                return Result(l_r.node, l_r.depth+1)
            return Result(r_r.node, r_r.depth+1)
        return helper(root).node