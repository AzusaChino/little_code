package cn.az.code.may;

import java.util.HashMap;
import java.util.Map;

/**
 * @author az
 * @date 2020/5/26
 */
public class ContiguousArray {

    public static void main(String[] args) {
        ContiguousArray ca = new ContiguousArray();
        System.out.println(ca.findMaxLength(new int[]{1, 0, 1, 0}));
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
