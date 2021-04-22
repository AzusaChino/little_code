#ifndef CPP_COMMON_H
#define CPP_COMMON_H

#endif //CPP_COMMON_H

class ListNode
{
public:
    int val;
    ListNode *next;

    ListNode() {}
    ListNode(int val) : val(val) {}
};

class TrieNode
{
public:
    bool isWord;
    TrieNode *children[];
};

class Trie
{
public:
    TrieNode root;
};

class TreeNode
{
public:
    int val;
    TreeNode *left;
    TreeNode *right;
};