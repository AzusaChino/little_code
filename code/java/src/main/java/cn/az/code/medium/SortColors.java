package cn.az.code.medium;

import java.util.Arrays;

/**
 * @author Liz
 * @date 1/15/2020
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] nums = new int[]{2,1,0,1,2,5,4,1};
        s.sortColors(nums);
    }

    public void sortColors(int[] nums) {
        System.out.println("before nums = " + Arrays.toString(nums));
        int[] buckets = new int[6];
        for(int num: nums) {
            buckets[num]++;
        }

        for (int i = 0, j = 0; j < 3; j++) {
            for (int count = 0; count < buckets[j]; count++) {
                nums[i++] = j;
            }
        }
        System.out.println("after nums = " + Arrays.toString(nums));
    }
}
