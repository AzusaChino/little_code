package cn.az.code.year2020.aug;

import java.util.Arrays;

/**
 * @author az
 * @since 08/04/20
 */
public class PowerOfFour {

    public static void main(String[] args) {
        System.out.println(new PowerOfFour()._isPowerOfFour(1));
    }
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }

    public boolean _isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }

    static class PowerOfTwo {
        static boolean is(int num) {
            return num > 0 && (num & (num - 1)) == 0;
        }
    }

    static class PowerOfThree {
        static boolean is(int num) {
            int maxPow3 = (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3)));
            return num > 0 && maxPow3 % num == 0;
        }

        public boolean isPowerOfThree(int n) {
            return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));
        }

        public boolean _isPowerOfThree(int n) {
            if (n > 1) {
                while (n % 3 == 0) {
                    n /= 3;
                }
            }
            return n == 1;
        }

        public boolean __isPowerOfThree(int n) {
            int[] allPowerOfThree = new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467};
            return Arrays.binarySearch(allPowerOfThree, n) >= 0;
        }
    }
}
