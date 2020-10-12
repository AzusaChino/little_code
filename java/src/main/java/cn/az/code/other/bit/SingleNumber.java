package cn.az.code.other.bit;

/**
 * @author az
 * @since 10/12/20
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ret = 0;
        // a ^ a = 0
        // 0 ^ b = b
        for (int n : nums) {
            ret ^= n;
        }
        return ret;
    }
}
