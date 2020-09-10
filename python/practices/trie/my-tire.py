class MyTrie:
    def __init__(self):
        self.root = {}
        self.end = '#'
    
    def add(self, word):
        node = self.root
        for c in word:
            node = node.setdefault(c, {})
        node.end = self.end
    
    def search(self, word):
        node = self.root
        for c in word:
            if c not in node:
                return False
            node = node[c]
        return node.end = self.end
    
    def starts_with(self, prefix):
        node = self.root
        for c in prefix:
            if c not in node:
                return False
            node = node[c]
        return True
