class WordDictionary:

    def __init__(self):
        self.root = {}

    def addWord(self, word):
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node['$'] = None

    def search(self, word):
        nodes = [self.root]
        for char in word + '$':
            nodes = [kid for node in nodes for kid in
                     ([node[char]] if char in node else
                      filter(None, node.values()) if char == '.' else [])]
        return bool(nodes)


class WordDictionary_(object):
    def __init__(self):
        self.trie = dict()

    def addWord(self, word):
        cur = self.trie
        for c in word + "$": cur = cur.setdefault(c, {})
        print(self.trie)

    def search(self, word, cur=None):
        if not cur: cur = self.trie
        return "$" in cur if not word \
            else self.search(word[1:], cur[word[0]]) if word[0] in cur \
            else False if 'a' <= word[0] <= 'z' \
            else any(self.search(word[1:], cur[c]) for c in cur if c != "$")


if __name__ == '__main__':
    wd = WordDictionary_()
    wd.addWord("hello")
    wd.addWord("halo")
