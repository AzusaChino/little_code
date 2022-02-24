package cn.az.code.year2020.aug;

import java.util.Arrays;

/**
 * @author az
 * @since 08/17/20
 */
public class DistributeCandies2People {

    public static void main(String[] args) {
        DistributeCandies2People dc = new DistributeCandies2People();
        System.out.println(Arrays.toString(dc.distribute(7, 4)));
    }

    public int[] distribute(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            res[give % num_people] +=  Math.min(candies, ++give);
        }
        return res;
    }
}
