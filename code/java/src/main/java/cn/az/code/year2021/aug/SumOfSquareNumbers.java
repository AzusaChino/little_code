package cn.az.code.year2021.aug;

/**
 * @author az
 * @since 2021-08-25
 */
public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
