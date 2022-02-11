package cn.az.code.year2021.may;

import java.util.Arrays;

/**
 * @author az
 * @since 2021-05-19
 */
public class MinimumMovesToEqualArrayElements2 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        return Arrays.stream(nums).boxed().map(x -> Math.abs(x - median)).reduce(0, (x, y) -> x + y);
    }
}