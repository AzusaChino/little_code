package cn.az.code.easy;

/**
 * @author : Liz
 * @date : 2019/10/30
 **/
public class MaximumSubArray053 {
    public static void main(String[] args) {

    }

    public static int maximum(int[] nums) {
        int maxSoFar = nums[0];
        int maxEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding, nums[i] + maxEnding);
            maxSoFar = Math.max(maxEnding, maxSoFar);
        }
        return maxSoFar;
    }
}
