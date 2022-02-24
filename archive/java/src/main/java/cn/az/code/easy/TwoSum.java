package cn.az.code.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Liz
 **/
public class TwoSum {

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 7;
        System.out.println(Arrays.toString(t.find(nums, target)));
    }

    public int[] find(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        System.out.println(map);
        return new int[]{-1, -1};
    }
}
