package cn.az.code.medium;

import java.util.Objects;

/**
 * 首尾房间不能同时被抢，那么只可能有三种不同情况：要么都不被抢；要么第一间房子被抢最后一间不抢；要么最后一间房子被抢第一间不抢
 * @author az
 * @date 2020/4/15
 */

public class HouseRobber2 {

    public static void main(String[] args) {
        HouseRobber2 h2 = new HouseRobber2();
        System.out.println(h2.rob2(new int[]{1, 2, 2, 25, 6, 7}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }

    public int rob(int[] nums, int l, int h) {
        int exclude = 0, include = 0;
        for (int j = l; j < h; j++) {
            int i = include, e = exclude;
            include = nums[j] + e;
            exclude = Math.max(e, i);
        }
        return Math.max(exclude, include);
    }

    public int rob2(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;

        int[][] dp = new int[len + 1][2];
        dp[1][0] = nums[0];

        for (int i = 2; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }


}
