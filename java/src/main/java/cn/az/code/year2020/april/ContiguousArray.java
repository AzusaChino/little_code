package cn.az.code.year2020.april;

import java.util.HashMap;
import java.util.Map;

/**
 * @author az
 * @date 5/3/2020
 */
public class ContiguousArray {

    public static void main(String[] args) {
        ContiguousArray ca = new ContiguousArray();
        int[] nums = new int[]{0, 1, 1, 0, 1, 1, 1, 0};
        System.out.println(ca.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        int len = nums.length, count = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>(8);
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;

    }
}
