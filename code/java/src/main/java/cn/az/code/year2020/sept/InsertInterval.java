package cn.az.code.year2020.sept;

import java.util.LinkedList;
import java.util.List;

/**
 * @author az
 * @since 09/13/20
 */
public class InsertInterval {

    /**
     * [[1,3],[4,5],[8,9]] + [3,7] => [[1,7],[8,9]]
     */
    public int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new LinkedList<>();
        int index = 0;
        // add all the intervals ending before newInterval starts
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            ret.add(intervals[index++]);
        }
        // merge all overlapping intervals to one considering newInterval
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval = new int[]{
                    Math.min(newInterval[0], intervals[index][0]),
                    Math.max(newInterval[1], intervals[index][1])
            };
            index++;
        }
        // add the union of intervals
        ret.add(newInterval);
        // add all the rest
        while (index < intervals.length) {
            ret.add(intervals[index++]);
        }

        return ret.toArray(new int[ret.size()][]);
    }
}
