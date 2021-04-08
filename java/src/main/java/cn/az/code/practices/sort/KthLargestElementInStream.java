package cn.az.code.practices.sort;

import java.util.PriorityQueue;

/**
 * @author az
 * @since 09/06/20
 */
public class KthLargestElementInStream {
    final PriorityQueue<Integer> pq;
    final int k;

    public KthLargestElementInStream(int k, int[] a) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int n: a) {
            pq.add(n);
        }
    }

    public int add(int n) {
        if (pq.size() < k) {
            pq.offer(n);
        } else if (pq.peek() < n) {
            pq.poll();
            pq.offer(n);
        }
        return pq.peek();
    }
}
