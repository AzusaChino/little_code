package cn.az.code.year2021.june;

import java.util.Arrays;

/**
 * @author az
 * @since 2021-06-14
 */
public class MaximumUnitsOnATruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int boxes = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                boxes += box[0] * box[1];
                truckSize -= box[0];
            } else {
                boxes += truckSize * box[1];
                return boxes;
            }
        }
        return boxes;
    }
}
