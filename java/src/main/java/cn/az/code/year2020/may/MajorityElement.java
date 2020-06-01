package cn.az.code.year2020.may;

import java.util.Arrays;

/**
 * @author az
 * @date 2020/5/7
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = new int[]{2, 2, 2, 2, 1, 1, 1, 3};
        System.out.println(me.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        return nums[mid];
    }

    public int majorityElements(int[] num) {

        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
