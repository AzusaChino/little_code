package cn.az.code.year2020.nov;

import java.util.Arrays;

/**
 * @author az
 * @since 11/10/20
 */
public class FlippingImage {

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        FlippingImage fi = new FlippingImage();
        System.out.println(Arrays.deepToString(fi.flipAndInvertImage(A)));
    }

    public int[][] flipAndInvertImage(int[][] A) {

        for (int[] a : A) {
            flip(a);
            invert(a);
        }
        return A;
    }

    private void flip(int[] a) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    private void invert(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                a[i] = 0;
                continue;
            }
            if (a[i] == 0) {
                a[i] = 1;
            }
        }
    }
}
