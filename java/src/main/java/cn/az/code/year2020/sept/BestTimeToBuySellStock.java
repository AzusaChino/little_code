package cn.az.code.year2020.sept;

public class BestTimeToBuySellStock {

    // 1. Recursive or BF
    public int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                max = Math.max(max, prices[j]-prices[i]);
            }
        }
        return max;
    }

    // 2. dp O(n) space
    public int maxProfit2(int[] prices) {
        int[] dp = new int[prices.length+1];
        dp[0] = 0;
        int ret = 0;
        for (int i = 1; i <= prices.length; i++) {
            dp[i] = Math.max(dp[i], d[i-1]);
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
    // 3. dp O(1) space
    public int maxProfit3(int[] prices) {
        

        return 0;
    }

}