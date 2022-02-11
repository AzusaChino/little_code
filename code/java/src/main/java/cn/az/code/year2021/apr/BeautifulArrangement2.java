package cn.az.code.year2021.apr;

/**
 * @author ycpang
 * @since 2021-04-12 16:24
 */
public class BeautifulArrangement2 {

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++) {
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        }
        return res;
    }
}
