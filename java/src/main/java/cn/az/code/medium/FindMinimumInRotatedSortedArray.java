package cn.az.code.medium;

/**
 * @author az
 * @date 2020/4/13
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums));
    }

    public static int search(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            int mid = (l + r) / 2;
            if ((nums[l] > nums[mid])) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }


}
