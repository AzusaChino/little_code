package cn.az.code.year2020.sept;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 09/08/20
 */
public class SumOfRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);

    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 2 + root.val;
        return root.left == root.right ? val : dfs(root.left ,val)+dfs(root.right, val);


    }

}
