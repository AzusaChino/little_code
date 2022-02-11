package cn.az.code.year2021.may;

import java.util.*;

/**
 * @author az
 * @since 2021-05-17
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;

        for (String w : words) {
            int best = 0;
            for (int i = 0; i < w.length(); ++i) {
                String prev = w.substring(0, i) + w.substring(i + 1);
                best = Math.max(best, map.getOrDefault(prev, 0) + 1);
            }
            map.put(w, best);
            res = Math.max(res, best);
        }

        return res;
    }

    public int _longestStrChain(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String w : words) {
            int len = w.length();
            map.computeIfPresent(len, (x, y) -> {
                y.add(w);
                return y;
            });
            map.putIfAbsent(len, new ArrayList<>(Collections.singletonList(w)));
        }

        return 0;
    }

}