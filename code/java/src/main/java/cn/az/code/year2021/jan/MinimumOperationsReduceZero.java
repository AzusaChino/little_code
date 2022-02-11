package cn.az.code.year2021.jan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ycpang
 * @since 2021/1/14 18:55
 */
public class MinimumOperationsReduceZero {

    public static void main(String[] args) {
        System.out.println(MinimumOperationsReduceZero.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
    }

    public static int minOperations(int[] nums, int x) {

        int target = -x;
        for (int num : nums) {
            target += num;
        }

        if (target == 0) {
            // since all elements are positive, we have to take all of them
            return nums.length;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; ++i) {

            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }

            // no need to check containsKey since sum is unique
            map.put(sum, i);
        }

        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }

}
