package cn.az.code.practices.untag;

import java.util.HashSet;
import java.util.Set;

/**
 * @author az
 * @date 2020/5/27
 */
public class ValidSudoku {

    public boolean valid(char[][] board) {
        int m = board.length, n = board[0].length;
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
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
