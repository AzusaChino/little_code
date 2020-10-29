package cn.az.code.year2020.oct;

/**
 * @author az
 * @since 10/29/20
 */
public class MaximizeDistanceClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int ret = 0, last = -1;
        int n = seats.length;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                ret = last < 0 ? i : Math.max(ret, (i - last) / 2);
                last = i;
            }
        }
        ret = Math.max(ret, (n - last - 1));

        return ret;
    }

}
