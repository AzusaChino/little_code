package cn.az.code.medium;

/**
 * @author Liz
 * @date 1/14/2020
 */
public class Search2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0
                || matrix[0].length == 0
                || matrix[0][0] > target
                || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
