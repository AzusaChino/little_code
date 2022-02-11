package cn.az.code.year2021.june;

/**
 * @author az
 * @since 2021-06-29
 */
public class MaxConsecutiveOnes3 {
    
    public int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }
}
