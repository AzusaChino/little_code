package cn.az.code.year2020.sept;

/**
 * @author az
 * @since 09/12/20
 */
public class MaxProductSubarray {

    public static void main(String[] args) {
        MaxProductSubarray ms = new MaxProductSubarray();
        System.out.println(ms.maxProduct(new int[]{2, 3, -4, 2}));
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int maxPos = nums[0], maxNeg = nums[0], ret = nums[0];
        for (int i = 1; i < n; i++) {
            maxPos = Math.max(maxPos * nums[i], Math.max(maxNeg * nums[i], nums[i]));
            maxNeg = Math.min(maxPos * nums[i], Math.min(maxNeg * nums[i], nums[i]));
            ret = Math.max(ret, maxPos);
        }
        return ret;
    }
}
