package cn.az.code.year2020.oct;

/**
 * @author az
 * @since 10/14/20
 */
public class HouseRob2 {

    public static void main(String[] args) {
        HouseRob2 hr = new HouseRob2();
        System.out.println(hr.rob(new int[]{0}));
        System.out.println(hr.rob(new int[]{1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        return Integer.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));

    }

    public int rob(int[] nums, int l, int r) {
        int pre = 0, cur = 0;
        for (int i = l; l <= r; l++) {
            int temp = Integer.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int ret = 0;
        for (int i = 1; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            ret = Math.max(ret, Math.max(dp[i][0], dp[i][1]));
        }

        return ret;
    }
}
