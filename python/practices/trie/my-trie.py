class MyTrie:
    def __init__(self):
        self.root = {}
        self.END_OF_LINE = '#'

    def add(self, word):
        node = self.root
        for c in word:
            node = node.setdefault(c, {})
        node[self.END_OF_LINE] = self.END_OF_LINE

    def search(self, word):
        node = self.root
        for c in word:
            if c not in node:
                return False
            node[c] = node
        return node[self.END_OF_LINE] == self.END_OF_LINE

    def starts_with(self, prefix):
        node = self.root
        for c in prefix:
            if c not in node:
                return False
            node[c] = node
        return True
