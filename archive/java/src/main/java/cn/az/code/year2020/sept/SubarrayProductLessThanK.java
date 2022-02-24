package cn.az.code.year2020.sept;

/**
 * little-code
 *
 * @author azusachino
 * @since 28/9/2020 21:17
 */
public class SubarrayProductLessThanK {

    public int subArray(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            // sliding window
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }
}
