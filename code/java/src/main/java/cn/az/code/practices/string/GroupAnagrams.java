package cn.az.code.practices.string;

import java.util.*;

/**
 * @author az
 * @since 10/12/20
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams_(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            Set<String> set = new HashSet<>();
            set.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagrams(strs[i], strs[j])) {
                    set.add(strs[j]);
                }
            }
            list.add(new ArrayList<>(set));
        }
        return list;
    }

    private boolean isAnagrams(String a, String b) {
        String[] as = a.split("");
        String[] bs = b.split("");
        Arrays.sort(as);
        Arrays.sort(bs);
        return String.join("", as).equals(String.join("", bs));
    }
}
