package cn.az.code.year2020.july;

/**
 * @author az
 * @since 2020-07-16 21:17
 */
public class Pow {

    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public double _myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        int res = 1;
        while (n > 1) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
