package cn.az.code.medium;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author: azusachino
 * @version: 2019/12/17
 */
public class GroupAnagrams_049 {

    public static void main(String[] args) {
        GroupAnagrams_049 g = new GroupAnagrams_049();
        System.out.println(g.groupAnagrams(new String[]{"aa","ab","ba",""}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String keyStr = String.valueOf(c);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr,new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());
    }

}
