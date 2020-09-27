package cn.az.code.other.dp;

import java.util.Arrays;

/**
 * little-code
 *
 * @author azusachino
 * @since 27/9/2020 23:26
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        // odd number can't partition
        if ((sum & 1) == 1) {
            return false;
        }
        int n = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }

            }
        }
        return dp[n][sum];
    }
}
