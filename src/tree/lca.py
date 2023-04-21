from index import TreeNode


def lca(root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
    ###
    # 1. 函数的作用是什么
    # 2. 参数中的变量是什么
    # 3. 得到函数的递归结果，应该做什么
    ###

    if not root:
        return root
    if root is p or root is q:
        return root
    l = lca(root.left, p, q)
    r = lca(root.right, p, q)

    if l or r:
        return root
    if not l and not r:
        return None
    if not l:
        return r
    return l
