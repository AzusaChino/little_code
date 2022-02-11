package cn.az.code.year2021.feb;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ycpang
 * @since 2021-02-04 16:09
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (long num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (long key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key + 1) + map.get(key));
            }
        }
        return result;
    }
}
