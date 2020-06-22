package cn.az.code.other.array;

/**
 * @author az
 * @since 2020-06-22 21:16
 */
public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums) {
                if ((n >> i & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            res |= sum << i;
        }
        return res;
    }
}
