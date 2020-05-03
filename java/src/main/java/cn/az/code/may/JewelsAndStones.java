package cn.az.code.may;

import java.util.HashSet;
import java.util.Set;

/**
 * @author az
 * @date 5/3/2020
 */
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>(16);
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        char[] chars = S.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
