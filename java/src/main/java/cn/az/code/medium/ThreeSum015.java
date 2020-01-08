package cn.az.code.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Liz
 * @version 2019/11/25
 */
public class ThreeSum015 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,-2,0,1,2,5}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi-1]) {
                            hi--;
                        }
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
