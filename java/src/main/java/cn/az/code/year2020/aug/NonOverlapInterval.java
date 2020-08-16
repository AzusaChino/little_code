package cn.az.code.year2020.aug;

import java.util.Arrays;

public class NonOverlapInterval {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length== 0) return 0;
        Arrays.sort(intervals, (a, b)-> a[1]-b[1]);
        int k =0, count =1, n = intervals.length;
        for(int i =1; i < n ; i++){
            if (intervals[i][0] >= intervals[k][1]){
                k = i;
                count++;
            }
        }
        return n-count;
    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;        

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
    
    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}