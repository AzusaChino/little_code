package cn.az.code.year2021.feb;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author az
 * @since 02/28/21 22:02
 */
public class MaximumFrequencyStack {
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Stack<Integer>> m = new HashMap<>();
    int maxFreq = 0;

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        maxFreq = Math.max(maxFreq, f);
        if (!m.containsKey(f)) {
            m.put(f, new Stack<>());
        }
        m.get(f).add(x);
    }

    public int pop() {
        int x = m.get(maxFreq).pop();
        freq.put(x, maxFreq - 1);
        if (m.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return x;
    }

}
