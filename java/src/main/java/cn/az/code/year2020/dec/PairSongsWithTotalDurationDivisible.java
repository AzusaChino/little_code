package cn.az.code.year2020.dec;

/**
 * @author az
 * @since 12/08/20 19:11
 */
public class PairSongsWithTotalDurationDivisible {

    public int numPairsDivisibleBy60(int[] time) {
        int[] c = new int[60];
        int res = 0;
        for (int t : time) {
            res += c[(600 - t) % 60];
            c[t % 60] += 1;
        }
        return res;
    }
}
