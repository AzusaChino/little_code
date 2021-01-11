package cn.az.code.year2021.jan;

/**
 * @author ycpang
 * @since 2021/1/11 19:21
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0 && j >= 0; k--) {
            nums1[k] = (i < 0 || nums1[i] < nums2[j]) ? nums2[j--] : nums1[i--];
        }
    }
}
