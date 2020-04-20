package cn.az.code.april;

/**
 * @author az
 * @date 2020/4/20
 */
public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 bs = new BestTimeToBuyAndSellStock2();
        int[] stocks = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bs.best(stocks));
    }

    public int best(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + (nums[i] - nums[i - 1]);
            }
        }
        return dp[len - 1];
    }
}
