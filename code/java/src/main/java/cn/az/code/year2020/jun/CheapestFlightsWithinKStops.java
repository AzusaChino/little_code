package cn.az.code.year2020.jun;

import java.util.*;

/**
 * @author az
 * @since 2020-06-15 07:30
 */
public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        // 1. convert to map(dict)
        for (int[] f : flights) {
            prices.putIfAbsent(f[0], new HashMap<>());
            prices.computeIfPresent(f[0], (k, v) -> {
                v.putIfAbsent(f[1], f[2]);
                return v;
            });
        }
        // 2. construct a PriorityQueue
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, src, K + 1});

        // 3. dfs
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) {
                return price;
            }
            if (stops > 0) {
                // get adjacent cities
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[]{price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }
}
