package cn.az.code.year2021.jan;

/**
 * @author az
 * @since 01/06/21 20:24
 */
public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        System.out.println(KthMissingPositiveNumber.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
    }

    public static int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (arr[m] - 1 - m < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l + k;
    }
}
