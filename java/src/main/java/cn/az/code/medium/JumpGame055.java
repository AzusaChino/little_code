package cn.az.code.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liz
 * @date 1/2/2020
 */
public class JumpGame055 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,4,1,1,4};
        int[] nums2 = new int[]{4,2,1,0,0,4};
        System.out.println(canJump2(nums1));
        System.out.println(canJump2(nums2));
    }

    public static boolean canJump2(int[] nums) {
        int farthest = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i <= farthest && nums[i] + i > farthest) {
                //i <= farthest is to make sure that this current i is within the current range
                // nums[i]+i > farthest is to make sure that it's necessary to update farthest with current nums[i]+i
                farthest = nums[i] + i;
            }
        }
        return farthest >= nums.length - 1;
    }


    public static boolean canJump(int[] nums) {
        if (nums[0] == 0) {
            return false;
        }

        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros.add(i);
            }
        }
        for (int zero : zeros) {
            int count = 0;
            for (int i = 0; i < zero; i++) {
                if (nums[i] == (zero - i)) {
                    count++;
                }
            }
            if (count == zero) {
                return false;
            }
        }
        return true;
    }
}
