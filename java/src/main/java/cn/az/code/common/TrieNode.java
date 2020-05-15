package cn.az.code.common;

/**
 * @author az
 * @date 5/15/2020
 */
public class TrieNode {

    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }
}
