package cn.az.code.year2021.feb;

import java.util.Arrays;

/**
 * @author ycpang
 * @since 2021-02-11 19:46
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 97]++;
        }
        for (char ch : t.toCharArray()) {
            freq[ch - 97]--;
        }

        return Arrays.equals(freq, new int[26]);
    }
}
