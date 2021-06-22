package cn.az.code.year2021.june;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 2021-06-22
 */
public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {

        int ans = 0;
        List<StringBuilder>[] waiting = new List[128];
        for (int c = 0; c <= 'z'; c++)
            waiting[c] = new ArrayList<>();
        for (String w : words)
            waiting[w.charAt(0)].add(new StringBuilder(w));

        for (char c : s.toCharArray()) {
            List<StringBuilder> advance = waiting[c];

            waiting[c] = new ArrayList<>();

            for (StringBuilder it : advance) {
                it.deleteCharAt(0);
                if (it.length() != 0)
                    waiting[it.charAt(0)].add(it);
                else
                    ans++;
            }
        }
        return ans;
    }

    private static boolean isSub(String x, String y) {

        int i = x.length(), j = y.length();
        if (i > j) {
            return false;
        }
        int k = 0;
        for (int z = 0; z < j; z++) {
            if (k == i) {
                return true;
            }
            if (y.charAt(z) == x.charAt(k)) {
                k++;
            }
        }
        return k == i;
    }

}
