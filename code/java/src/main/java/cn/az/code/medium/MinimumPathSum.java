package cn.az.code.medium;

import java.util.Arrays;

/**
 * @author Liz
 * @date 1/10/2020
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] i = new int[3][3];
        i[0] = new int[]{1,2,3};
        i[1] = new int[]{1,2,3};
        i[2] = new int[]{1,2,3};
        System.out.println("minPathSum(i) = " + minPathSum(i));

    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int height = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < height; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < width; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println("Arrays.deepToString(dp) = " + Arrays.deepToString(dp));
        return dp[height - 1][width - 1];
    }
}
