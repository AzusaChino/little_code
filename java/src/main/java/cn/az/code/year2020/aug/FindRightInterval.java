package cn.az.code.year2020.aug;

import java.util.*;

/**
 * @author az
 * @since 08/27/20
 */
public class FindRightInterval {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
    }

    public static int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i][1]);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }

    public static int[] findRightInterval2(int[][] intervals) {

        int len = intervals.length;
        if (len < 1) {
            return new int[]{};
        } else if (len == 1) {
            return new int[]{-1};
        }

        int[] res = new int[len];
        Arrays.fill(res, -1);

        // 1. 把所有的右值和下标存入HashMap
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < len; i++) {
            dict.put(i, intervals[i][1]);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    break;
                }
                if (intervals[i][1] <= intervals[j][0]) {
                    res[i] = Math.min(res[i], j);
                }
            }
        }

        return res;
    }

    public int[] findRightInterval3(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key != null ? map.get(key) : -1;
        }
        return res;
    }
}
