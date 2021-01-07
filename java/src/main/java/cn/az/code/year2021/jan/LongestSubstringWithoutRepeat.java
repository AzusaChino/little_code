package cn.az.code.year2021.jan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ycpang
 * @since 2021/1/7 18:33
 */
public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, longest = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            } else {
                longest = Math.max(longest, i - start + 1);
            }
            map.put(c, i);
        }
        return longest;
    }
}
