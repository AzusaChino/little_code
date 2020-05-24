package cn.az.code.may;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author az
 * @date 2020/5/24
 */
public class SortCharactersByFrequency {

    public String frequencySorting(String s) {
        Map<Character, Integer> map = new HashMap<>(16);

        IntStream.range(0, s.length()).forEach(i -> map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1));

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            IntStream.range(0, e.getValue()).forEach(i -> sb.append(e.getKey()));
        }
        return sb.toString();
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (bucket[pos] != null) {
                for (char c : bucket[pos]) {
                    sb.append(String.valueOf(c).repeat(pos));
                }
            }
        }

        return sb.toString();
    }
}
