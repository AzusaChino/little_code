package cn.az.code.year2020.jun;

/**
 * @author az
 * @date 10/6/2020
 */
public class SearchInsertPosition {

    public static void main(String[] args) {

    }

    public int _searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return len;
    }

    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length, l = 0, r = len - 1;
        if (target <= nums[0]) {
            return 0;
        }
        if (target >= nums[r]) {
            return len;
        }
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target || (nums[mid] > target && nums[mid - 1] < target)) {
                return mid;
            }
            if (nums[mid] < target && nums[mid + 1] > target) {
                return mid + 1;
            }
            if (nums[mid] > target) {
                r = mid;
            }
            if (nums[mid] < target) {
                l = mid;
            }
        }
        return -1;
    }
}
