package cn.az.code.practices.dp;

import java.util.Arrays;

/**
 * @author az
 * @since 09/12/20
 */
public class LongestIncreasingSequence {

    public static void main(String[] args) {
        LongestIncreasingSequence ls = new LongestIncreasingSequence();
        int[] squence = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] squence2 = new int[]{10, 9, 2, 5, 3, 4};
//        System.out.println(ls.lengthOfLIS(squence));
        System.out.println(ls.lengthOfLIS(squence2));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ret = 1, n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public int lengthOfLISBF(int[] nums) {
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            int curCount = 1, last = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > last) {
                    curCount++;
                    last = nums[j];
                }
            }
            ret = Math.max(ret, curCount);
        }

        return ret;
    }

    public int lengthOfLis(int[] nums) {
        int n = nums.length;
        int[] top = new int[n];
        int piles = 0;
        for (int poker : nums) {
            int l = 0, r = piles;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (top[mid] < poker) {
                    r = mid;
                } else if (top[mid] > poker) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (l == piles) {
                piles++;
            }
            top[l] = poker;
        }
        return piles;
    }
}
