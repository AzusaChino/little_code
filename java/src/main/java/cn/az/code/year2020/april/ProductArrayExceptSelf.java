package cn.az.code.year2020.april;

import java.util.Arrays;

/**
 * @author az
 * @date 2020/4/29
 */
public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        ProductArrayExceptSelf paes = new ProductArrayExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(paes.productExceptSelf(nums)));
    }

    //Numbers:     2    3    4     5
    //Lefts:       1    2  2*3 2*3*4
    //Rights:  3*4*5  4*5    5     1

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public int[] productExceptSelf_(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        for (int i = 0; i < len; i++) {
            output[i] = helper(nums, i);
        }
        return output;
    }

    private int helper(int[] nums, int cur) {
        int[] dummy = Arrays.copyOf(nums, nums.length);
        dummy[cur] = 1;
        int result = 1;
        for (int d : dummy) {
            result *= d;
        }
        return result;
    }
}
