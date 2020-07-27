from common import TreeNode


class Solution:
    def buildTree(self, preorder, inorder):
        '''
        Use the first element of preorder, the 1, as root.
        Search it in inorder.
        Split inorder by it, here into [4, 2, 5] and [6, 3].
        Split the rest of preorder into two parts as large as the inorder parts, here into [2, 4, 5] and [3, 6].
        Use preorder = [2, 4, 5] and inorder = [4, 2, 5] to add the left subtree.
        Use preorder =[3, 6]andinorder = [6, 3] to add the right subtree.
        :param preorder:
        :param inorder:
        :return:
        '''
        def build(stop):
            if inorder and inorder[-1] != stop:
                root = TreeNode(preorder.pop())
                root.left = build(root.val)
                inorder.pop()
                root.right = build(stop)
                return root

        preorder.reverse()
        inorder.reverse()
        return build(None)
