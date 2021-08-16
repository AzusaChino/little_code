package cn.az.code.year2021.aug;

/**
 * @author az
 * @since 2021-08-16
 */
public class RangeSumQueryImmutable {

    int[] nums;

    public RangeSumQueryImmutable(int[] nums) {
        for (int i = 1; i < nums.length; i++) nums[i] += nums[i - 1];

        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0) return nums[j];

        return nums[j] - nums[i - 1];
    }
}
