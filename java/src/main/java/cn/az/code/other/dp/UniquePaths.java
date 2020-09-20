package cn.az.code.other.dp;

import java.util.Arrays;

/**
 * @author az
 * @since 09/20/20
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3, 7));
    }

    /**
     * bottom top solution
     *
     * @param m m
     * @param n n
     * @return paths count
     */
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        // 最右
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        // 最下
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public int paths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }
}
