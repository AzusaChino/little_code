package cn.az.little.easy;

/**
 * @author : Liz
 * @date : 2019/10/31
 **/
public class PlusOne_066 {

    public static void main(String[] args) {

    }

    public int[] plus(int[] digits) {
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
