package cn.az.code.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Spiral matrix 054.
 *
 * @author Liz
 * @date 12 /31/2019
 */
public class SpiralMatrix_054 {
    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;

    /**
     * Spiral order list.
     *
     * @param matrix the matrix
     * @return the list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        int direction = 0;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            switch (direction) {
                case RIGHT:
                    for (int col = colStart; col <= colEnd; col++) {
                        res.add(matrix[rowStart][col]);
                    }
                    rowStart++;
                    break;
                case DOWN:
                    for (int row = rowStart; row <= rowEnd; row++) {
                        res.add(matrix[row][colEnd]);
                    }
                    colEnd--;
                    break;
                case LEFT:
                    for (int col = colEnd; col >= colStart; col--) {
                        res.add(matrix[rowEnd][col]);
                    }
                    colEnd--;
                    break;
                case UP:
                    for (int row = rowEnd; row >= rowStart; row--) {
                        res.add(matrix[row][colStart]);
                    }
                    colEnd--;
                    break;
                default:
                    break;
            }
            direction = (direction + 1) % 4;
        }
        return res;
    }
}
