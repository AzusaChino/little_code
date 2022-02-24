package cn.az.code.year2020.aug;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author az
 * @since 08/13/20
 */
public class CombinationIterator {

    Queue<String> pq = new LinkedList<>();

    public CombinationIterator(String s, int k) {
        generateSub(s, k, 0, new StringBuilder());
    }

    private void generateSub(String s, int len, int start, StringBuilder result) {
        if (len == 0) {
            pq.add(result.toString());
            return;
        }
        for (int i = start; i <= s.length() - len; i++) {
            result.append(s.charAt(i));
            generateSub(s, len - 1, i + 1, result);
            result.deleteCharAt(result.length() - 1);
        }
    }

    public String next() {
        return pq.poll();
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }
}
