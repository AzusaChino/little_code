package cn.az.code.practices.dp;

/**
 * little-code
 *
 * @author azusachino
 * @since 27/9/2020 23:16
 */
public class Bag {

    // w weight, n stones

    public int maxValue(int w, int n, int[] wt, int[] nt) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            // choose stone
            for (int j = 1; j <= w; j++) {
                // no enough space
                if (j - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // put or not put into bag
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[j - 1]] + nt[i - 1]);
                }
            }
        }
        return dp[n][w];
    }
}
