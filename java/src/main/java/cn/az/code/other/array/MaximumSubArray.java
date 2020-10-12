package cn.az.code.other.array;

/**
 * @author az
 * @since 10/12/20
 */
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
