package cn.az.code.year2021.feb;

/**
 * @author ycpang
 * @since 2021-02-23 19:27
 */
public class Search2dMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    // TLE 124/128

    public boolean searchMatrix_(int[][] matrix, int target) {
        boolean[] ret = new boolean[1];
        helper(matrix, 0, 0, target, ret);
        return ret[0];
    }

    private void helper(int[][] matrix, int x, int y, int target, boolean[] ret) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || target < matrix[x][y]) {
            return;
        }
        if (matrix[x][y] == target) {
            ret[0] = true;
        }
        helper(matrix, x + 1, y, target, ret);
        helper(matrix, x, y + 1, target, ret);
    }
}
