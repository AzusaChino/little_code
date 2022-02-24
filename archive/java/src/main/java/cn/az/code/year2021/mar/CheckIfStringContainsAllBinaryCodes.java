package cn.az.code.year2021.mar;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ycpang
 * @since 2021-03-12 17:10
 */
public class CheckIfStringContainsAllBinaryCodes {

    public boolean hasAllCodes(String s, int k) {
        Set<String> seen = new HashSet<>();
        for (int i = k; i <= s.length() && seen.size() < 1 << k; ++i) {
            seen.add(s.substring(i - k, i));
        }
        return seen.size() == 1 << k;
    }
}
