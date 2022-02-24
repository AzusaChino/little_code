package cn.az.code.year2020.jun;

import java.util.Arrays;

public class TwoCityScheduling {

    public static void main(String[] args) {

    }

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i] + costs[i - 1][1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[n][n];
    }

    public int twoCitesCost(int[][] costs) {
        int n = costs.length / 2;

        int[] refund = new int[n * 2];

        int minCost = 0, index = 0;

        for (int[] cost : costs) {
            // refund[i] = cost[i][1] - cost[i][0]
            refund[index++] = cost[1] - cost[0];
            // send all people to city A
            minCost += cost[0];
        }
        // most refund
        Arrays.sort(refund);
        for (int i = 0; i < n; i++) {
            minCost += refund[i];
        }
        return minCost;
    }
}
