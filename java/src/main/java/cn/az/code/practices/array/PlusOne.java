package cn.az.code.practices.array;

/**
 * @author az
 * @date 5/14/2020
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] d = new int[len + 1];
        d[0] = 1;
        return d;
    }
}
