package cn.az.code.medium;

import java.util.*;

/**
 * @author Liz
 * @date 1/3/2020
 */
public class MergeIntervals056 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(n -> n[0]));
        int[] start = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(start);
        for(int[] interval : intervals){
            if (interval[0] <= start[1]) {
                start[1] = Math.max(start[1], interval[1]);
            } else {
                start = interval;
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
