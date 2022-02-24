package cn.az.code.year2020.april;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 10/15/20
 */
public class ConstructBstFromPreOrderTraversal {

    int index = 0;
    int i = 0;

    public static void main(String[] args) {
        ConstructBstFromPreOrderTraversal cb = new ConstructBstFromPreOrderTraversal();
        System.out.println(cb.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }

    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }

    public TreeNode _bstFromPreorder(int[] preorder) {
        return buildTree(preorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] nums, int bound) {
        if (index == nums.length) {
            return null;
        }
        int cur = nums[index];
        if (cur > bound) {
            return null;
        }
        index++;
        TreeNode root = new TreeNode(cur);
        root.left = buildTree(nums, cur);
        root.right = buildTree(nums, bound);
        return root;
    }

}
