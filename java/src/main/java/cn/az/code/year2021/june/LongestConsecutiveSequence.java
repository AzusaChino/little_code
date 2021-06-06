package cn.az.code.year2021.june;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author az
 * @since 2021-06-06
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                // duplicates
                continue;
            }
        }
        return res;
    }

    public int _longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums)
            set.add(num);
        int max = 1;
        for (int num : nums) {
            if (set.remove(num)) {// num hasn't been visited
                int val = num;
                int sum = 1;
                while (set.remove(val - 1))
                    val--;
                sum += num - val;

                val = num;
                while (set.remove(val + 1))
                    val++;
                sum += val - num;

                max = Math.max(max, sum);
            }
        }
        return max;
    }

}
