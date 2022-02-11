package cn.az.code.practices.array;

/**
 * @author az
 * @since 2020-06-22 21:16
 */
public class SingleNumber {

    /**
     * 0 ^ N = N
     * N ^ N = 0
     * So..... if N is the single number
     * <p>
     * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
     * <p>
     * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
     * <p>
     * = 0 ^ 0 ^ ..........^ 0 ^ N
     * <p>
     * = N
     */
    int singleNumber(int[] nums, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
