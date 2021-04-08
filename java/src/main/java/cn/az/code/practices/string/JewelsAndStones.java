package cn.az.code.practices.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author az
 * @since 2020-06-18 22:07
 */
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char ch : J.toCharArray()) {
            set.add(ch);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public int _newJewelInStones(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }
}
