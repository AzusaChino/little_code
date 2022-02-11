package cn.az.code.year2021.jan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ycpang
 * @since 2021/1/18 19:12
 */
public class MaxNumberSumPairs {

    public static void main(String[] args) {
        System.out.println(MaxNumberSumPairs.maxOperations(new int[]{3, 1, 3, 5, 3}, 6));
    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(k - num)) {
                res++;
                if (map.get(k - num) == 1) {
                    map.remove(k - num);
                } else {
                    map.put(k - num, map.get(k - num) - 1);
                }
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return res;
    }

    public static int _maxOperations(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == k) {
                    count++;
                    nums[i] = nums[j] = Integer.MAX_VALUE;
                }
            }
        }
        return count;
    }
}
