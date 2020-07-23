package cn.az.code.year2020.july;

/**
 * @author az
 * @since 07/23/20
 */
public class SingleNumber {

    int singleNumber1(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }

    int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int n : nums) {
            ones = ((ones ^ n)) & ~twos;
            twos = ((twos ^ n)) & ~ones;
        }
        return ones;
    }

    int[] singleNumber3(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        diff &= -diff;

        int[] ret = new int[]{0, 0};
        for (int n : nums) {
            if ((n & diff) == 0) {
                ret[0] = n;
            } else {
                ret[1] = n;
            }
        }
        return ret;

    }
}
