#include <map>

using namespace std;

class Trie
{
public:
    Trie()
    {
    }

    void insert(string word)
    {
        Trie *node = this;
        for (char ch : word)
        {
            if (!node->next.count(ch))
            {
                node->next[ch] = new Trie();
            }
            node = node->next[ch];
        }
        node->isWord = true;
    }

    bool search(string word)
    {
        Trie *node = this;
        for (char ch : word)
        {
            if (!node->next.count(ch))
            {
                return false;
            }
            node = node->next[ch];
        }
        return node->isWord;
    }

    bool startsWith(string prefix)
    {
        Trie *node = this;
        for (char ch : prefix)
        {
            if (!node->next.count(ch))
            {
                return false;
            }
            node = node->next[ch];
        }
        return true;
    }

private:
    map<char, Trie *> next = {};
    bool isWord = false;
};