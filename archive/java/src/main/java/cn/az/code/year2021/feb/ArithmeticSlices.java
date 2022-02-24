package cn.az.code.year2021.feb;

/**
 * 2021-02-18 | Arithmetic Slices | 413
 *
 * @author az
 * @since 02/19/21 08:02
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        }
        return sum;
    }
}
