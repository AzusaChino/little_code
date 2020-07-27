package cn.az.code.year2020.july;

import cn.az.code.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author az
 * @since 07/27/20
 */
public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {

    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            hm.put(inorder[i], i);
        }
        return buildTreePostIn(0, inorder.length - 1, postorder, 0,
                postorder.length - 1, hm);
    }

    private TreeNode buildTreePostIn(int is, int ie, int[] postorder, int ps, int pe,
                                     Map<Integer, Integer> hm) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(is, ri - 1, postorder, ps, ps + ri - is - 1, hm);
        TreeNode rightchild = buildTreePostIn(ri + 1, ie, postorder, ps + ri - is, pe - 1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

    static class ConstructBinaryTreeFromPreorderAndInOrderTraversal {
        private int in = 0;
        private int pre = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, inorder, Integer.MIN_VALUE);
        }

        private TreeNode build(int[] preorder, int[] inorder, int stop) {
            if (pre >= preorder.length) {
                return null;
            }
            if (inorder[in] == stop) {
                in++;
                return null;
            }
            TreeNode node = new TreeNode(preorder[pre++]);
            node.left = build(preorder, inorder, node.val);
            node.right = build(preorder, inorder, stop);
            return node;
        }
    }
}
