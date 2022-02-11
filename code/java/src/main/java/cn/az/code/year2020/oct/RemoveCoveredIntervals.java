package cn.az.code.year2020.oct;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] A) {
        int res = 0, left = -1, right = -1;
        Arrays.sort(A, Comparator.comparingInt(a -> a[0]));
        for (int[] v : A) {
            if (v[0] > left && v[1] > right) {
                left = v[0];
                ++res;
            }
            right = Math.max(right, v[1]);
        }
        return res;
    }

    public int removeCoveredIntervals2(int[][] A) {
        int res = 0, right = 0;
        Arrays.sort(A, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int[] v : A) {
            if (v[1] > right) {
                ++res;
                right = v[1];
            }
        }
        return res;
    }
}