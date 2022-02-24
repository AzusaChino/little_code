from collections import deque
from typing import List

from common import TreeNode


def level_order(root: TreeNode) -> List[List[int]]:
    if not root:
        return []
    queue, res = deque([root]), []

    while queue:
        cur_level, size = [], len(queue)
        for i in range(size):
            node = queue.popleft()
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
            cur_level.append(node.val)
        res.append(cur_level)
    return res
