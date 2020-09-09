package cn.az.code.practice.some;

/**
 * @author az
 * @since 09/09/20
 */
public class MySqrt {

    int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 1, r = x, res = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                r = m - 1;
            } else if (m < x / m) {
                l = m + 1;
                res = m;
            }
        }
        return res;
    }

    int sqrtNewton(int x) {
        int r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return r;
    }
}
