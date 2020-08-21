package cn.az.code.year2020.aug;

import java.util.Arrays;

/**
 * @author az
 * @since 08/21/20
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        SortArrayByParity sp = new SortArrayByParity();
        SortArrayByParity2 sp2 = new SortArrayByParity2();
//        System.out.println(Arrays.toString(sp.sortArrayByParity(new int[]{3, 2, 1, 2, 4})));
        System.out.println(Arrays.toString(sp2.sortArrayByParityII(new int[]{3, 2, 1, 2, 4})));
    }

    public int[] sortArrayByParity(int[] A) {
        // i始终记录上一个奇数的位置
        for (int i = 0, j = 0; j < A.length; j++) {
            if ((A[j] & 1) == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }

    public int[] mySortArrayByParity(int[] A) {
        int even = 0, odd = A.length - 1;
        int[] res = new int[A.length];

        for (int a : A) {
            if ((a & 1) == 1) {
                res[odd--] = a;
            } else {
                res[even++] = a;
            }
        }
        return res;
    }

    static class SortArrayByParity2 {
        public int[] sortArrayByParityII(int[] A) {
            int i = 0, j = 1, n = A.length;
            while (i < n && j < n) {
                // 找偶数不在偶数位置上
                while (i < n && (A[i] & 1) == 0) {
                    i += 2;
                }
                // 找奇数不在奇数位置上
                while (j < n && (A[j] & 1) == 1) {
                    j += 2;
                }
                if (i < n && j < n) {
                    swap(A, i, j);
                }
            }
            return A;
        }

        private void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
