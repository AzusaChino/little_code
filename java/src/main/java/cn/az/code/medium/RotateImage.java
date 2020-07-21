package cn.az.code.medium;

/**
 * @author azusachino
 * @version 2019/12/16
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int s = 0, len = matrix.length-1;

        while (s < len) {
            int[] temp = matrix[s];
            matrix[s] = matrix[len];
            matrix[len] = temp;
            s++; len--;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }

        }
    }
}
