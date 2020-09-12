package cn.az.code.other.dp;

/**
 * @author az
 * @since 09/12/20
 */
public class BestTimeBuySell {

    public static void main(String[] args) {
        BestTimeBuySellOnce once = new BestTimeBuySellOnce();
        BestTimeBuySellNoLimit noLimit = new BestTimeBuySellNoLimit();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(once.maxValue(prices));
        System.out.println(noLimit.maxValue(prices));
    }

    // 121
    static class BestTimeBuySellOnce {
        public int maxValue(int[] prices) {
            int min = prices[0], ret = -prices[0];
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                if (i > 0) {
                    ret = Math.max(ret, prices[i] - min);
                }
            }
            return ret;
        }
    }

    // 122
    static class BestTimeBuySellNoLimit {
        public int maxValue(int[] prices) {
            int ret = 0;
            for (int i = 1; i < prices.length; i++) {
                ret += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ret;
        }
    }

    // 123 买卖2次
    static class BestTimeBuySellTwice {
        public int maxValue(int[] prices) {
            int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
            int release1 = 0, release2 = 0;
            for (int p : prices) {
                release2 = Math.max(release2, hold2 + p);
                hold2 = Math.max(hold2, release1 - p);
                release1 = Math.max(release1, hold1 + p);
                hold1 = Math.max(hold1, -p);
            }
            return release2;
        }

    }

    // 188 买卖k次
    static class BestTimeBuySellK {
        public int maxValue(int[] prices) {
            int ret = 0;

            return ret;
        }
    }
}
