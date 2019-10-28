package cn.az.little.easy;

/**
 * @author : Liz
 * @date : 2019/10/28
 **/
public class RemoveElement_027 {

    public static int remove(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
