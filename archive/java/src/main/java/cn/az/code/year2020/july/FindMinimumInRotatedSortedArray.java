package cn.az.code.year2020.july;

import java.util.Arrays;

/**
 * no duplicate
 *
 * @author az
 * @since 07/25/20
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

    public int _findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    /**
     * contains duplicate
     */
    static class FindMinimumInRotatedSortedArray2 {
        int findMin(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            int mid = 0;

            while (lo < hi) {
                mid = lo + (hi - lo) / 2;

                if (nums[mid] > nums[hi]) {
                    lo = mid + 1;
                } else if (nums[mid] < nums[hi]) {
                    hi = mid;
                } else { // when num[mid] and num[hi] are same 过滤重复
                    hi--;
                }
            }
            return nums[lo];
        }
    }
}
