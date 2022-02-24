package cn.az.code.medium;

/**
 * @author Liz
 * @date 1/19/2020
 */
public class WordSearch {

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        char[][] board = new char[3][3];
        board[0] = new char[]{'a', 'b', 'c'};
        board[1] = new char[]{'c', 'a', 'b'};
        String word = "acabac";
        System.out.println("w.exist(board,word) = " + w.exist(board, word));
    }

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
