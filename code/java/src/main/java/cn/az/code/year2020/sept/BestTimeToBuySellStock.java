package cn.az.code.year2020.sept;

/**
 * @author az
 * @since 20.09.18
 */
public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        BestTimeToBuySellStock b = new BestTimeToBuySellStock();
        System.out.println(b.maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
    }

    // 1. Recursive or BF
    public int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    // 2. dp O(n) space
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + (prices[i] - prices[i - 1]));
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    // 3. dp O(1) space
    public int maxProfit3(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public int maxProfit4(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(price - min, max);
        }
        return max;
    }

}