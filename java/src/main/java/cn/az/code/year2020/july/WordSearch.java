package cn.az.code.year2020.july;

/**
 * @author az
 * @since 07/21/20
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(index)) {
            return false;
        }
        board[i][j] = '*';
        boolean res = exist(board, i - 1, j, word, index + 1) ||
                exist(board, i, j - 1, word, index + 1) ||
                exist(board, i + 1, j, word, index + 1) ||
                exist(board, i, j + 1, word, index + 1);
        board[i][j] = word.charAt(index);
        return res;
    }
}
