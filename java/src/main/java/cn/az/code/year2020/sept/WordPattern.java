package cn.az.code.year2020.sept;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author az
 * @since 09/07/20
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }
        return toPattern(pattern,"").equals(toPattern(str, " "));
    }

    private String toPattern(String s, String regexp) {
        String[] strings = s.split(regexp);
        Map<String, String> map = new LinkedHashMap<>(16);
        for (int i = 0; i < strings.length; i++) {
            int finalI = i;
            String cur = strings[i];
            map.putIfAbsent(cur, String.valueOf(i));
            map.computeIfPresent(cur, (k, v) -> v.concat(String.valueOf(finalI)));
        }
        return map.values().stream().reduce("", String::concat);
    }
}
