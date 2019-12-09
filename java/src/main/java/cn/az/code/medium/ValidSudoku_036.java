package cn.az.code.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author azusachino
 * @version 2019/12/09
 */
public class ValidSudoku_036 {
    public static void main(String[] args) {
    }

    /**
     * Collect the set of things we see, encoded as strings. For example:
     * '4' in row 7 is encoded as "(4)7".
     * '4' in column 7 is encoded as "7(4)".
     * '4' in the top-right block is encoded as "0(4)2".
     * Scream false if we ever fail to add something because it was already added (i.e., seen before).
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
