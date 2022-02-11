package cn.az.code.year2020.july;

import java.util.Arrays;

/**
 * @author az
 * @since 2020-07-06 22:08
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(Arrays.toString(PlusOne.plusOne(new int[]{1, 9, 9, 9})));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}
