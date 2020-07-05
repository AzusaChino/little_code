package cn.az.code.year2020.july;

/**
 * @author az
 * @since 2020-07-05 23:13
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    int _hammingDistance(int x, int y) {
        int d = 0;
        int bitxor = x ^ y;

        while (bitxor > 0) {
            if (bitxor % 2 == 1) {
                d++;
            }
            bitxor = bitxor >> 1;
        }

        return d;
    }

    static class TotalHammingDistance {
        public int totalHammingDistance(int[] nums) {
            int total = 0, n = nums.length;
            for (int j = 0; j < 32; j++) {
                int bitCount = 0;
                for (int num : nums) {
                    bitCount += (num >> j) & 1;
                }
                total += bitCount * (n - bitCount);
            }
            return total;
        }
    }
}
