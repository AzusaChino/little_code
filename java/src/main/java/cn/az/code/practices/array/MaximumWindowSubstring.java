package cn.az.code.practices.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author az
 * @since 09/15/20
 */
public class MaximumWindowSubstring {

    public String maxWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0){
            return "";
        }
        // corner cases

        Map<Character, Integer> windowMap = new HashMap<>(), targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right++);
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (targetMap.get(c).equals(windowMap.get(c))) {
                    valid++;
                }
            }
            while (valid == targetMap.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left++);
                if (targetMap.containsKey(d)) {
                    if (targetMap.get(d).equals(windowMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
