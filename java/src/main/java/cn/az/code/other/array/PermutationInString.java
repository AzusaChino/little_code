package cn.az.code.other.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author az
 * @since 09/15/20
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        // The length of both given strings is in range [1, 10,000].
        Map<Character, Integer> targetMap = new HashMap<>(), windowMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right++);
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (targetMap.get(c).equals(windowMap.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == targetMap.size()) {
                    return true;
                }
                char d = s2.charAt(left++);
                if (targetMap.containsKey(d)) {
                    if (targetMap.get(d).equals(windowMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        return false;
    }
}
