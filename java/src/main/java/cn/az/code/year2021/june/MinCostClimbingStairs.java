package cn.az.code.year2021.june;

/**
 * @author az
 * @since 2021-06-07
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
    
}
