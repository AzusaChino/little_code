package cn.az.code.other.untag;

/**
 * little-code
 *
 * @author azusachino
 * @since 2/10/2020 17:10
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }

        // adding 1 (1 & self)
        int sum = 1;
        // exclude 1
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }

        return sum == num;
    }
}
