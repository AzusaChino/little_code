package cn.az.code.year2020.oct;

import java.util.Arrays;

/**
 * @author az
 * @since 10/31/20
 */
public class NumberLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len = new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) cnt[i] += cnt[j];
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max_len == len[i]) res += cnt[i];
            if (max_len < len[i]) {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }

    public int findNumberOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        // dp[i] means the lengh of LIS ending at i
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        // cnt[i] means # LIS ending at i
        int[] cnt = new int[len];

        int ret = 0, max = 1;
        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (1 + dp[j] > dp[i]) {
                        count = cnt[j];
                        dp[i] = 1 + dp[j];
                    } else if (1 + dp[j] == dp[i]) {
                        count += cnt[j];
                    }
                }
            }
            cnt[i] = count;

            if (dp[i] > max) {
                ret = count;
                max = dp[i];
            } else if (dp[i] == max) {
                ret += count;
            }
        }
        return ret;
    }
}
