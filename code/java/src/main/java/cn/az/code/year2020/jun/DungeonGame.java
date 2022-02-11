package cn.az.code.year2020.jun;

/**
 * @author az
 * @since 2020-06-21 21:05
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        if (null == dungeon || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }

        return dp[0][0];
    }

    public int _calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n + 1];
        dp[n]  = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int health;
                if (i == m - 1) {
                    health = dp[j + 1] - dungeon[i][j];
                } else if (j == n - 1) {
                    health = dp[j] - dungeon[i][j];
                } else {
                    health = Math.min(dp[j + 1], dp[j]) - dungeon[i][j];
                }
                dp[j] = health <= 0 ? 1 : health;
            }
        }
        return dp[0];
    }
}
