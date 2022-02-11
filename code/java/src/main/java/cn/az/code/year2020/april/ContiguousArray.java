package cn.az.code.year2020.april;

import java.util.Arrays;
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
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }

    public int findMaxLength_(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
