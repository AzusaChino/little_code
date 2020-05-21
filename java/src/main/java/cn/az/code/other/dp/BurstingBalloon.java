package cn.az.code.other.dp;

/**
 * @author az
 * @date 2020/5/21
 */
public class BurstingBalloon {

    /**
     *
     * @param nums nums
     * @return coins
     */
    int maxCoins(int[] nums) {
        int len = nums.length;
        int[] points = new int[len + 2];
        points[0] = points[len + 1] = 1;

        for (int i = 1; i <= len; i++) {
            points[i] = nums[i - 1];
        }

        int[][] dp = new int[len + 2][len + 2];

        for (int i = len; i >= 0; i--) {
            for (int j = i + 1; j < len + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
