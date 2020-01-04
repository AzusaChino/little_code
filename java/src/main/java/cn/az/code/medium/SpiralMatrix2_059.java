package cn.az.code.medium;

import java.util.Arrays;

/**
 * @author Liz
 * @date 1/4/2020
 */
public class SpiralMatrix2_059 {

    public static void main(String[] args) {
        SpiralMatrix2_059 spiralMatrix2059 = new SpiralMatrix2_059();
        System.out.println(Arrays.deepToString(spiralMatrix2059.generateMatrix(4)));
    }

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        if (n <= 0) {
            return res;
        }
        int num = 1, rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        while (colStart <= colEnd && rowStart <= rowEnd) {
            for (int col = colStart; col <= colEnd; col++) {
                res[rowStart][col] = num++;
            }

            rowStart++;
            for (int row = rowStart; row <= rowEnd; row++) {
                res[row][colEnd] = num++;
            }
            colEnd--;

            for (int col = colEnd; col >= colStart; col--) {
                res[rowEnd][col] = num++;
            }
            rowEnd--;

            for (int row = rowEnd; row >= rowStart; row--) {
                res[row][colStart] = num++;
            }
            colStart++;

        }
        return res;
    }
}
