package cn.az.code.year2021.may;

import java.util.PriorityQueue;

/**
 * @author az
 * @since 2021-05-09
 */
public class ConstructTargetArrayWithMultipleSums {

    public boolean isPossible(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        long total = 0;
        for (int a : A) {
            total += a;
            pq.add(a);
        }
        while (true) {
            int a = pq.poll();
            total -= a;
            if (a == 1 || total == 1)
                return true;
            if (a < total || total == 0 || a % total == 0)
                return false;
            a %= total;
            total += a;
            pq.add(a);
        }
    }

}