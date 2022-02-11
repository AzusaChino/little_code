package cn.az.code.year2021.feb;

import cn.az.code.common.TreeNode;

/**
 * @author ycpang
 * @since 2021-02-09 22:02
 */
public class ConvertBstGreaterTree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) {
            return;
        }
        // 从最右子树开始，每次更新sum
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}
