package cn.az.code.year2021.jan;

import java.util.Arrays;

/**
 * @author az
 * @since 01/31/21 19:20
 */
public class NextPermutation {

    // The following algorithm generates the next permutation lexicographically after a given permutation. It changes the given permutation in-place.

    public void nextPermutation(int[] nums) {
        // Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
        int k = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                k = i;
            }
        }
        if (k == -1) {
            Arrays.sort(nums);
            return;
        }

        // Find the largest index l greater than k such that a[k] < a[l].
        int l = k + 1;
        for (int i = k + 2; i < nums.length; i++) {
            if (nums[k] < nums[i]) {
                l = i;
            }
        }

        // Swap the value of a[k] with that of a[l].
        int tmp = nums[k];
        nums[k] = nums[l];
        nums[l] = tmp;

        // Reverse the sequence from a[k + 1] up to and including the final element a[n].
        for (int i = 1; k + i < nums.length - i; i++) {
            tmp = nums[k + i];
            nums[k + i] = nums[nums.length - i];
            nums[nums.length - i] = tmp;
        }
    }

}
