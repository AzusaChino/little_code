package cn.az.code.year2020.oct;

import java.util.TreeMap;

/**
 * little-code
 *
 * @author azusachino
 * @since 2/10/2020 16:36
 */
public class RecentCounter {

    TreeMap<Integer, Integer> tm;

    public RecentCounter() {
        tm = new TreeMap<>();
    }

    public int ping(int t) {
        tm.put(t, 1 + tm.size());
        return tm.tailMap(t - 3000).size();
    }
}
