package cn.az.code.year2021.july;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author az
 * @since 2021-07-11
 */
public class FindMedianFromDataStream {

    private Queue<Long> small = new PriorityQueue<>(), large = new PriorityQueue<>();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size()) large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
            ? large.peek()
            : (large.peek() - small.peek()) / 2.0;
    }
}
