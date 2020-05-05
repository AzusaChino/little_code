package cn.az.code.other.array;

/**
 * @author az
 * @date 5/4/2020
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
            }
            nums[i] = nums[j];
        }
        return i + 1;
    }
}
