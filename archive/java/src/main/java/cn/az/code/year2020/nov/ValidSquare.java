package cn.az.code.year2020.nov;

import java.util.Arrays;

/**
 * @author az
 * @since 11/11/20
 */
public class ValidSquare {

    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 0};
        int[] p3 = {1, 1};
        int[] p4 = {0, 1};
        ValidSquare vs = new ValidSquare();
    }

    //  p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] matrix = new int[][]{p1, p2, p3, p4};
        Arrays.sort(matrix, (a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);

        return true;
    }
}
