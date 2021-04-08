package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

/**
 * little-code
 *
 * @author azusachino
 * @since 24/9/2020 07:43
 */
public class ConvertSortedArrayBinarySearchTree {

    // normal bst

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    // using binary search

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}
