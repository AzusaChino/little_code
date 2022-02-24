package cn.az.code.year2021.mar;

import java.util.Arrays;

/**
 * @author ycpang
 * @since 2021-03-01 16:09
 */
public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        Arrays.sort(candyType);
        int count = 1;
        for (int i = 0, j = 0; i < len; i++) {
            if (candyType[i] != candyType[j]) {
                j = i;
                count++;
            }
        }
        return Math.min(count, len / 2);
    }
}
