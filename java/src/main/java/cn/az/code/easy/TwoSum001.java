package cn.az.code.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Liz
 * @date : 2019/10/19
 **/
public class TwoSum001 {

    public static void main(String[] args) {
        TwoSum001 t = new TwoSum001();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 7;
        System.out.println(Arrays.toString(t.find(nums, target)));
    }

    public int[] find(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(10);
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
