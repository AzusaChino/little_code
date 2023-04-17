class TrieNode:
    def __init__(self, c, is_word=False):
        self.c = c
        self.is_word = is_word
        self.children = [None] * 26


class Trie:
    def __init__(self):
        self.root = TrieNode("#")

    def insert(self, s: str):
        if not s:
            return
        node = self.root
        for i in range(len(s)):
            idx = ord(s[i]) - ord("a")
            node.children[idx] = TrieNode(s[i])
            node = node.children[idx]
        node.is_word = True

    def find(self, s: str) -> bool:
        if not s:
            return False
        node = self.root
        for i in range(len(s)):
            idx = ord(s[i]) - ord("a")
            if node.children[idx]:
                node = node.children[idx]
            else:
                return False
        return node.is_word


if __name__ == "__main__":
    t = Trie()
    t.insert("hello")
    print(t.find("hell"))
    print(t.find("hello"))
