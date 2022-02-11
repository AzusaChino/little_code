package cn.az.code.year2021.june;

import java.util.HashMap;
import java.util.Map;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @since 2021-06-08
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    int preOrderIndex;
    Map<Integer, Integer> inOrderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        inOrderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToTree(preorder, left, inOrderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inOrderIndexMap.get(rootValue) + 1, right);
        
        return root;
    }
}
