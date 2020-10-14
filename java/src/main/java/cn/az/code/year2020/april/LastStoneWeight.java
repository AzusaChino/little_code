package cn.az.code.year2020.april;

import java.util.PriorityQueue;

/**
 * @author az
 * @since 10/14/20
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a : A) {
            pq.offer(a);
        }
        while (pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }
}
