package cn.az.code.year2020.aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 08/29/20
 */
public class PancakeSorting {

    /**
     * Find the index i of the next maximum number x.
     * Reverse i + 1 numbers, so that the x will be at A[0]
     * Reverse x numbers, so that x will be at A[x - 1].
     * Repeat this process N times.
     *
     * @param A A
     * @return list
     */
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length, i; x > 0; --x) {
            for (i = 0; A[i] != x; ++i)
            reverse(A, i + 1);
            res.add(i + 1);
            reverse(A, x);
            res.add(x);
        }
        return res;
    }

    public void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
