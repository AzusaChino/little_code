const buildTree = (preorder, inorder) => {
    p = i = 0
    build = function (stop) {
        if (inorder[i] !== stop) {
            let root = new TreeNode(preorder[p++])
            root.left = build(root.val)
            i++
            root.right = build(stop)
            return root
        }
        return null
    }
    return build()
};