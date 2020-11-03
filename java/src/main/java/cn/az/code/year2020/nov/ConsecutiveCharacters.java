package cn.az.code.year2020.nov;

import java.util.Arrays;

/**
 * @author az
 * @since 11/03/20
 */
public class ConsecutiveCharacters {

    public int maxPower(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        // base case
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = s.charAt(i) == s.charAt(i - 1) ? dp[i - 1] + 1 : dp[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
