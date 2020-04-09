from common import TreeNode

def dfs(node: TreeNode):
    if node in visited:
        # already visited
        return
    visited.add(node)

    # process current node
    process(node)
    dfs(node.left)
    dfs(node.right)