package cn.az.code.year2020.sept;

import java.util.Arrays;

/**
 * @author az
 * @since 09/01/20
 */
public class LargestTimeForGivenDigits {

    public String largestTimeFromDigits(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        String ans = "";
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                for (int k = 0; k < len; ++k) {
                    if (i == j || i == k || j == k) {
                        continue; // avoid duplicate among i, j & k.
                    }
                    String h = "" + A[i] + A[j], m = "" + A[k] + A[6 - i - j - k], t = h + ":" + m; // hour, minutes, & time.
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(t) < 0) {
                        ans = t; // hour < 24; minute < 60; update result.
                    }
                }
            }
        }
        return ans;
    }
}
