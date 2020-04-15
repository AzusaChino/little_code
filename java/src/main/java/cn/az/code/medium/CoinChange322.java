package cn.az.code.medium;

import java.util.Arrays;

/**
 * @author az
 * @date 2020/4/11
 */
public class CoinChange322 {

    public static void main(String[] args) {
        CoinChange322 c = new CoinChange322();
        System.out.println(c.coinChange2(new int[]{1,2,5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if (rem < 0) {
            // not valid
            return -1;
        }
        if (rem == 0) {
            // completed
            return 0;
        }
        if (count[rem - 1] != 0) {
            // already computed, so reuse
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public int coinChange2(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }
}
