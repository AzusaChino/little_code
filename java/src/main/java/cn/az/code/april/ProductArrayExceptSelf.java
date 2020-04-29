package cn.az.code.april;

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

    public int[] productExceptSelf(int[] nums) {
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
