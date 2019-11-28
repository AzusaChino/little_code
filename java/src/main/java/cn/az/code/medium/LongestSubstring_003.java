package cn.az.code.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Liz
 * @date : 2019/11/12
 **/
public class LongestSubstring_003 {
    public static void main(String[] args) {
        System.out.println(solution("pepper"));
    }

    public static int solution(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(16);
        int len = s.length();
        int result = 0;
        for (int i = 0, j = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);

        }
        return result;
    }
}
