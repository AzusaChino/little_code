package cn.az.code.year2020.nov;

/**
 * @author az
 * @since 11/05/20
 */
public class MinimumCostMoveChipSamePosition {

    public int minCost(int[] position) {
        int o = 0, e = 0;

        for (int j : position) {
            if ((j & 1) == 0) {
                e++;
            } else {
                o++;
            }

        }

        return Math.min(o, e);
    }

}
