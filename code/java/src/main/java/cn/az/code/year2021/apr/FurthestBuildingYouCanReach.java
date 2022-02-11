package cn.az.code.year2021.apr;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author ycpang
 * @since 2021-04-26 15:32
 */
public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int d = heights[i + 1] - heights[i];
            // use ladders
            if (d > 0) {
                pq.add(d);
            }
            // no ladders left
            if (pq.size() > ladders) {
                bricks -= Objects.requireNonNull(pq.poll());
            }
            // no bricks left
            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }
}
