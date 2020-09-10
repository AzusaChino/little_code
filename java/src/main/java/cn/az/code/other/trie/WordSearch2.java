package cn.az.code.other.trie;

import cn.az.code.year2020.may.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author az
 * @since 09/10/20
 */
public class WordSearch2 {

    Set<String> set = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length, n = board[0].length;
        // 开启二维数组 记录访问
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, boolean[][] visited, String s, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board.length || visited[x][y]) {
            return;
        }
        s += board[x][y];
        if (!trie.startsWith(s)) {
            return;
        }
        if (trie.search(s)) {
            set.add(s);
        }
        visited[x][y] = true;

        dfs(board, visited, s, x - 1, y, trie);
        dfs(board, visited, s, x + 1, y, trie);
        dfs(board, visited, s, x, y - 1, trie);
        dfs(board, visited, s, x, y + 1, trie);

        visited[x][y] = false;
    }
}
