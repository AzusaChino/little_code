package cn.az.code.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author azusachino
 * @version 2019/12/09
 */
public class ValidSudoku036 {

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

    public boolean isValidSudoku2(char[][] board) {
        for(int i = 0;i < 9;i++){
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] boxCheck = new boolean[9];
            for(int j = 0;j< 9;j++){
                if(board[i][j] == '.'){}
                else if(rowCheck[board[i][j] - '1']) {
                    return false;
                } else {
                    rowCheck[board[i][j] - '1'] = true;
                }
                if(board[j][i] == '.'){}
                else if(colCheck[board[j][i] - '1']) {
                    return false;
                } else {
                    colCheck[board[j][i] - '1'] = true;
                }
                int m = i/3*3 + j/3;
                int n = i%3*3 + j%3;
                if(board[m][n] == '.') {}
                else if(boxCheck[board[m][n] - '1']) {
                    return false;
                } else {
                    boxCheck[board[m][n] - '1'] = true;
                }
            }
        }
        return true;
    }
}
