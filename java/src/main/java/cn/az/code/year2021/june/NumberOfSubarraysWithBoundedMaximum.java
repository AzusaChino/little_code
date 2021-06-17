package cn.az.code.year2021.june;

/**
 * @author az
 * @since 2021-06-17
 */
public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i0 = 0, res = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                count = 0;
                i0 = i + 1;
            } else if (nums[i] >= left)
                count = i - i0 + 1;
            res += count;
        }
        return res;
    }
}
