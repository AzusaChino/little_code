package cn.az.code.easy;

/**
 * @author : Liz
 * @date : 2019/10/30
 **/
public class MaximumSubArray053 {

    public static void main(String[] args) {
        MaximumSubArray053 ms = new MaximumSubArray053();
        System.out.println(ms.maximum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maximum(int[] nums) {
        int maxSoFar = nums[0];
        int maxEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(nums[i], nums[i] + maxEnding);
            maxSoFar = Math.max(maxEnding, maxSoFar);
        }
        return maxSoFar;
    }
}
