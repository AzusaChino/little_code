package cn.az.code.year2021.may;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author az
 * @since 2021-05-02
 */
public class CourseSchedule3 {
    
    public int scheduleCourse(int[][] C) {
        Arrays.sort(C, (a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int total = 0;
        for (int[] course : C) {
            int dur = course[0], end = course[1];
            if (dur + total <= end) {
                total += dur;
                pq.add(dur);
            } else if (pq.size() > 0 && pq.peek() > dur) {
                total += dur - pq.poll();
                pq.add(dur);
            }
        }
        return pq.size();
    }
}