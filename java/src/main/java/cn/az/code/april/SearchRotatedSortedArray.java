package cn.az.code.april;

/**
 * @author az
 * @date 2020/4/29
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        int[] nums = new int[]{3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(s.search(nums, 7));
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len <= 0) {
            return -1;
        }
        int l = 0, r = len - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
