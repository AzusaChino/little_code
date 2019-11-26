package cn.az.leetcode.medium;

import java.util.Arrays;

/**
 * @author Liz
 * @version 2019/11/26
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 2, 3, 4, 5}, Integer.MAX_VALUE));
    }

    public static int sum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        if (len <= 3) {
            for (int i : nums) {
                res += i;
            }
            return res;
        }
        res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                    if (res == target) {
                        return res;
                    }
                } else if (target > sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
