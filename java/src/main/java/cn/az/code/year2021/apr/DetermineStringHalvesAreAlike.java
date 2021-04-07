package cn.az.code.year2021.apr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @author ycpang
 * @since 2021-04-07 16:23
 */
public class DetermineStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int l = s.length() / 2;
        s = s.toLowerCase();
        String sl = s.substring(0, l);
        String sr = s.substring(l);
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'i', 'u', 'e', 'o'));
        int il = 0, ir = 0;
        for (char c : sl.toCharArray()) {
            if (set.contains(c))
                il++;
        }
        for (char c : sr.toCharArray())
            if (set.contains(c))
                ir++;

        return il == ir;
    }
}
