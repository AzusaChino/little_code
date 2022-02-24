package cn.az.code.year2020.may;

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

}
