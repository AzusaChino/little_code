package cn.az.code.year2021.mar;

/**
 * @author ycpang
 * @since 2021-03-03 16:36
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {

        // In a complete array with no missing numbers,
        // the index and value should be perfectly corresponding( nums[index] = index),
        // so in a missing array, what left finally is the missing number.
        int xor = 0, i;
        for (i = 0; i < nums.length; i++) {
            // a^b^b =a
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    public static int missingNumber_(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += i - nums[i];
        }
        return sum;
    }
}
