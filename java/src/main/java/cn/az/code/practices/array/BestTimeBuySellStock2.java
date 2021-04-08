package cn.az.code.practices.array;

/**
 * @author az
 * @date 5/11/2020
 */
public class BestTimeBuySellStock2 {

    public static void main(String[] args) {
        BestTimeBuySellStock2 b2 = new BestTimeBuySellStock2();
        System.out.println(b2.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        int max = 0, len = prices.length;
        int slow = 0;
        for (int i = 1; i < len; i++) {
            int l = prices[slow], r = prices[i];
            if (l < r) {
                max += r - l;
            }
            slow = i;
        }
        return max;
    }
}
