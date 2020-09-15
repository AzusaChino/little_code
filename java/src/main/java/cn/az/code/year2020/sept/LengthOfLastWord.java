package cn.az.code.year2020.sept;

import java.util.Arrays;

/**
 * @author az
 * @since 09/15/20
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        String[] last = s.split(" ");
        return last[last.length-1].length();
    }
}
