package cn.az.code.medium;

import java.util.Arrays;

/**
 * @author azusachino
 * @version 2019/12/08
 */
public class FirstLastElementSortedArray034 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange1(nums, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstLast(nums, target, true);
        result[1] = findFirstLast(nums, target, false);
        return result;
    }

    private int findFirstLast(int[] nums, int target, boolean first) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid] || (first && target == nums[mid])) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
            if(nums[mid] == target) {
                idx = mid;
            }
        }
        return idx;
    }
    public static int[] searchRange1(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    private static int[] helper(int[] nums, int target, int lo, int hi) {
        if (nums[lo] == target && nums[hi] == target) {
            return new int[]{lo, hi};
        }
        if (nums[lo] <= target && nums[hi] >= target) {
            int mid = lo + (hi - lo) >> 1;
            int[] left = helper(nums, target, lo, mid);
            int[] right = helper(nums, target, mid + 1, hi);
            if (left[0] == -1) {
                return right;
            }
            if (right[0] == -1) {
                return left;
            }
            return new int[]{left[0], right[1]};
        }
        return new int[]{-1, -1};
    }

    public static int[] search(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int l = 0, r = nums.length - 1, temp = 0;
        while (l <= r) {
            int mid = l + (r - l) >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                break;
            }
        }

        return res;
    }
}
