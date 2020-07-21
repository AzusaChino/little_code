package cn.az.code.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Liz
 * @date : 2019/10/23
 **/
public class RomanInteger {
    public static void main(String[] args) {
        System.out.println(convert("MCMXCIV"));
    }

    private static int convert(String str) {
        Map<Character, Integer> map = new HashMap<>(10);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i > 1 && map.get(str.charAt(i)) > map.get(str.charAt(i - 1))) {
                ret += map.get(str.charAt(i)) - 2 * map.get(str.charAt(i - 1));
            } else {
                ret += map.get(str.charAt(i));
            }
        }
        return ret;
    }
}
