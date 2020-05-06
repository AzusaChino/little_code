package cn.az.code.may;

import java.util.*;

/**
 * @author az
 * @date 2020/5/5
 */
public class FirstUniqueCharacterString {

    public static void main(String[] args) {
        FirstUniqueCharacterString fucs = new FirstUniqueCharacterString();
        System.out.println(fucs.firstUniqChar("leetcode"));
    }

    public int firstUniqChar(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>(8);
        int slow = 0, fast = 1;
        set.add(chars[0]);
        for (; fast < s.length(); fast++) {

            if (set.contains(chars[fast])) {
                slow++;
            }
        }

        return slow == s.length()-1 ? -1 : slow;
    }

    public int another(String s) {
        int[] freq = new int[26];
        // count every char occur
        for(int i = 0; i < s.length(); i ++) {
            freq [s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < s.length(); i ++) {
            if(freq [s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;

    }
}
