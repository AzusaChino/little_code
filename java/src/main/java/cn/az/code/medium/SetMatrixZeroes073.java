package cn.az.code.medium;

import java.util.Arrays;

/**
 * @author Liz
 * @date 1/13/2020
 */
public class SetMatrixZeroes073 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 1, 3};
        matrix[1] = new int[]{0, 2, 3};
        matrix[2] = new int[]{1, 0, 3};
        setMatrix(matrix);
    }

    public static void setMatrix(int[][] matrix) {
        System.out.println("before matrix = " + Arrays.deepToString(matrix));
        if (matrix != null) {
            int width = matrix.length, height = matrix[0].length;
            for (int i = 0; i < width; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 0; j < height; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 0; j < width; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }
        System.out.println("after matrix = " + Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        fr = true;
                    }
                    if (j == 0) {
                        fc = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fr){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (fc){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
