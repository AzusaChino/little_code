package cn.az.code.year2020.oct;

/**
 * @author az
 * @since 10/16/20
 */
public class Search2dMatrix {

    /**
     * Do binary search in this "ordered" matrix
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid / col_num][mid % col_num];

            if (mid_value == target) {
                return true;

            } else if (mid_value < target) {
                //Should move a bit further, otherwise dead loop.
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    boolean searchMatrix_(int[][] matrix, int target) {
        int m = matrix.length, n = 1;
        if (m > 0) {
            n = matrix[0].length;
        }
        int l = 0, r = m * n - 1;
        while (l != r) {
            int mid = (l + r - 1) >> 1;
            if (matrix[mid / m][mid % m] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return matrix[r / m][r % m] == target;
    }
}
