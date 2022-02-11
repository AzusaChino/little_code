package cn.az.code.easy;

/**
 * @author : Liz
 * @date : 2019/10/29
 **/
public class SearchInsertPosition {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return len;
    }
}
