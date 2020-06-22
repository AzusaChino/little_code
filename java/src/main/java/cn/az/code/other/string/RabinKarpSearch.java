package cn.az.code.other.string;

/**
 * @author az
 * @since 2020-06-22 23:15
 */
public class RabinKarpSearch {

    public final static int D = 256;
    public final static int Q = 9997;

    public static int rabinKarpSearch(String txt, String pat) {
        int m = pat.length(), n = txt.length();

        int i, j, patHash = 0, txtHash = 0;

        for (i = 0; i < m; i++) {
            patHash = (D * patHash + pat.charAt(i)) % Q;
            txtHash = (D * txtHash + txt.charAt(i)) % Q;
        }

        int highestPow = 1;
        for (i = 0; i < m - 1; i++) {
            highestPow = (highestPow * D) % Q;
        }
        for (i = 0; i <= n - m; i++) {
            if (patHash == txtHash) {
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    return i;
                }
            }
            if (i < n - m) {
                txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + m)) % Q;
                if (txtHash < 0) {
                    txtHash += Q;
                }
            }
        }
        return -1;
    }
}
