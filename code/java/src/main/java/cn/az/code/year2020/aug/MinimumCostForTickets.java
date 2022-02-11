package cn.az.code.year2020.aug;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author az
 * @since 08/25/20
 */
public class MinimumCostForTickets {


    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[30];
        int d = 0; // d means the index of next travel day
        int lastDay = days[days.length - 1];

        for (int i = days[0]; i <= lastDay; i++) {
            if (i != days[d]) {
                dp[i % 30] = dp[(i - 1) % 30]; // we don't have third day for travel, price as yesterday
            } else { // i == days[d]
                dp[i % 30] = Math.min(dp[(i - 1) % 30] + costs[0], Math.min(dp[Math.max(i - 7, 0) % 30] + costs[1], dp[Math.max(i - 30, 0) % 30] + costs[2]));
                d++;
            }
        }


        return dp[lastDay % 30];
    }


    public int minCostTickets(int[] days, int[] costs) {
        // using queue so that the oldest ticket is at the top.
        Queue<int[]> last7days = new LinkedList<>(), last30days = new LinkedList<>();

        int totalCost = 0;
        for (int day : days) {
            // discarding expired 7days pass
            while (!last7days.isEmpty() && last7days.peek()[0] + 7 <= day) {
                last7days.poll();
            }

            last7days.offer(new int[]{day, totalCost + costs[1]});

            // discarding expired 30 days pass.
            while (!last30days.isEmpty() && last30days.peek()[0] + 30 <= day) {
                last30days.poll();
            }

            last30days.offer(new int[]{day, totalCost + costs[2]});

            // taking the min of daily pass and current valid 7 days or 30 days pass.
            assert last7days.peek() != null;
            assert last30days.peek() != null;
            totalCost = Math.min(totalCost + costs[0], Math.min(last30days.peek()[1], last7days.peek()[1]));
        }

        return totalCost;
    }
}
