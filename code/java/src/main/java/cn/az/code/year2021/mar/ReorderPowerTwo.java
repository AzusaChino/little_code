package cn.az.code.year2021.mar;

/**
 * @author az
 * @since 03/21/21 18:06
 */
public class ReorderPowerTwo {

    public boolean reorderedPowerOf2(int N) {
        long c = counter(N);
        for (int i = 0; i < 32; i++) {
            if (counter(1 << i) == c) {
                return true;
            }
        }
        return false;
    }

    public long counter(int N) {
        long res = 0;
        for (; N > 0; N /= 10) {
            res += (int) Math.pow(10, N % 10);
        }
        return res;
    }
}
