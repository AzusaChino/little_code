package cn.az.code.year2020.april;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * @author az
 * @date 2020/4/20
 */
public class SingleNumber {

    public static void main(String[] args) {

    }

    /**
     * first , we have to know the bitwise XOR in java
     *
     * 0 ^ N = N
     * N ^ N = 0
     * So..... if N is the single number
     *
     * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
     *
     * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
     *
     * = 0 ^ 0 ^ ..........^ 0 ^ N
     *
     * = N
     * @param nums nums
     * @return single
     */
    public int singleNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }

}
