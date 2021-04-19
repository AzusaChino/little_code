package cn.az.code.year2021.apr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ycpang
 * @since 2021-04-19 16:25
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        return helper(nums, target, new HashMap<>());
    }

    private int helper(int[] nums, int target, Map<Integer, Integer> map) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int res = 0;
        for (int num : nums) {
            int cnt = helper(nums, target - num, map);
            if (target >= num) {
                map.put(target - num, cnt);
            }
            res += cnt;
        }
        return res;
    }
}
