package cn.az.code.year2021.july;

import java.util.Random;

/**
 * @author az
 * @since 2021-07-20
 */
public class ShuffleAnArray {

    private int[] nums;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null)
            return null;
        int[] a = nums.clone();
        for (int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
