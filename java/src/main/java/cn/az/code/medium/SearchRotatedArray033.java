package cn.az.code.medium;

/**
 * @author Liz
 * @version 2019/12/07
 */
public class SearchRotatedArray033 {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(search(nums,14));
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            double num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            if (num < target) {
                l = mid + 1;
            } else if (num > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
