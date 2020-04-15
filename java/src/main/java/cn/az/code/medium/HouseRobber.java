package cn.az.code.medium;

/**
 * @author az
 * @since 2020-04-15
 */
public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber hs = new HouseRobber();
        System.out.println(hs.maxValue2(new int[]{2, 7, 9, 3, 1}));
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
