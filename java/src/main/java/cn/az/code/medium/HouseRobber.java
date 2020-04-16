package cn.az.code.medium;

import java.util.Arrays;

/**
 * @author az
 * @since 2020-04-15
 */
public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber hs = new HouseRobber();
        long start = System.currentTimeMillis();
        System.out.println(hs.rob3(new int[]{2, 7, 9, 3, 1, 6, 7, 8, 9, 3, 3, 2, 3, 2}));
        System.out.println("using " + (System.currentTimeMillis() - start));
    }

    public int rob1(int[] nums) {
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        return Math.max(dp(nums, start + 1),
                nums[start] + dp(nums, start + 2));
    }

    private int[] memo;

    public int rob2(int[] nums) {
        memo = new int[nums.length + 1];

        return dp2(nums, 0);
    }

    private int dp2(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] > 0) {
            return memo[start];
        }
        memo[start] = Math.max(dp2(nums, start + 1),
                nums[start] + dp2(nums, start + 2));
        return memo[start];
    }

    public int maxValue(int[] houses) {

        int n = houses.length;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = houses[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + houses[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int maxValue2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    /**
     * 自底向上
     * @param nums houses
     * @return money
     */
    public int rob3(int[] nums) {
        int n = nums.length;
        // dp[i] = x 表示：
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[n] = 0
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }
    /**
     * wrong answer
     */
    public int maxValue3(int[] nums) {
        int odd = nums[0], even = 0;

        for (int i = 1; i < nums.length; i++) {
            if ((i & 2) != 0) {
                even += nums[i];
            } else {
                odd += nums[i];
            }
        }
        return Math.max(odd, even);
    }

    /**
     * 自顶向下
     * @param nums houses
     * @return money
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
