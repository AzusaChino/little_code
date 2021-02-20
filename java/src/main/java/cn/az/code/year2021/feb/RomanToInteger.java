package cn.az.code.year2021.feb;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ycpang
 * @since 2021-02-20 16:33
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                ret += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                ret += map.get(s.charAt(i));
            }
        }
        return ret;
    }
}
