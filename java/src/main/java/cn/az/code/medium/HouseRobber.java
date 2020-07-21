package cn.az.code.medium;

import cn.az.code.common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * house robber
 * @author az
 * @date 2020/4/16
 */
public class HouseRobber {

    public static void main(String[] args) {

    }

    /**
     * put map out(for recursive)
     */
    Map<TreeNode, Integer> memo = new HashMap<>(16);

    public int rob(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int doIt = root.val
                + (Objects.isNull(root.left) ? 0 : rob(root.left.right))
                + (Objects.isNull(root.right) ? 0 : rob(root.right.left));

        int notDoIt = rob(root.left) + rob(root.right);

        int res = Math.max(doIt, notDoIt);
        memo.put(root, res);
        return res;
    }

    public int robDp(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dp(TreeNode root) {
        if (Objects.isNull(root)) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);

        int rob = root.val + left[0] + right[0];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{notRob, rob};
    }
}
