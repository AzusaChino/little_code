package cn.az.code.practices.dp;

/**
 * @author az
 * @date 2020/5/21
 */
public class MaxSubArraySum {

    int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        // base case
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int d : dp) {
            res = Math.max(res, d);
        }
        return res;
    }

    int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp0 = nums[0];
        int dp1 = 0, res = 0;

        for (int i = 1; i < n; i++) {
            dp1 = Math.max(nums[i], nums[i] + dp0);
            dp0 = dp1;
            res = Math.max(res, dp1);
        }
        return res;
    }

}
