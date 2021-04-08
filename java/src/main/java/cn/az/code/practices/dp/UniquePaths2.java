package cn.az.code.practices.dp;

/**
 * @author az
 * @since 09/20/20
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] path = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                while (i < n) {
                    path[i][0] = 0;
                    i++;
                }
            } else {
                path[i][0] = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (obstacleGrid[0][j] == 1) {
                while (j < m) {
                    path[0][j] = 0;
                    j++;
                }
            } else {
                path[0][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                } else {
                    path[i][j] = 0;
                }
            }
        }
        return path[n - 1][m - 1];

    }
}
