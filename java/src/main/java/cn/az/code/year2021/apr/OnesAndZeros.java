package cn.az.code.year2021.apr;

/**
 * @author ycpang
 * @since 2021-04-02 16:41
 */
public class OnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int cntZero = 0, cntOne = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    cntZero++;
                } else {
                    cntOne++;
                }
            }
            for (int i = m; i >= cntZero; i--) {
                for (int j = n; j >= cntOne; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - cntZero][j - cntOne] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
