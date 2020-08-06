package cn.az.code.year2020.aug;

/**
 * @author az
 * @since 08/05/20
 */
public class WordDictionary {

    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int k, TrieNode ws) {
        if (k == chs.length) {
            return ws.isWord;
        }
        if (chs[k] == '.') {
            for (int i = 0; i < ws.children.length; i++) {
                if (ws.children[i] != null && match(chs, k + 1, ws.children[i])) {
                    return true;
                }
            }
        } else {
            return ws.children[chs[k] - 'a'] != null && match(chs, k + 1, ws.children[chs[k] - 'a']);
        }
        return false;
    }

    private static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }
}
