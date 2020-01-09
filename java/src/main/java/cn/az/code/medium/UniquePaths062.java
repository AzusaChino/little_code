package cn.az.code.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Liz
 * @date 1/8/2020
 */
@Slf4j
public class UniquePaths062 {

    public static void main(String[] args) {
        UniquePaths062 uniquePaths062 = new UniquePaths062();
        System.out.println(uniquePaths062.uniquePath(3, 3));
    }

    public int uniquePath(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        log.info(Arrays.deepToString(dp));
        return dp[m - 1][n - 1];
    }
}
