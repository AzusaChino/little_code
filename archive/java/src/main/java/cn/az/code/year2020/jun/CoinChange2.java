package cn.az.code.year2020.jun;

public class CoinChange2 {

    public static void main(String[] args) {
        CoinChange2 cc = new CoinChange2();
        int[] coins = new int[]{1,2,5};
        System.out.println(cc.change(12,coins));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
