import collections
from typing import List


class WordSearch:
    def __init__(self):
        self.dx = [-1, 1, 0, 0]
        self.dy = [0, 0, -1, 1]
        self.end_of_word = '#'
        self.ret = set()
        self.m = 0
        self.n = 0

    def find_words(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0] or not words:
            return []
        root = collections.defaultdict()
        for word in words:
            node = root
            for c in word:
                node = node.setdefault(c, collections.defaultdict())
            node[self.end_of_word] = self.end_of_word

        self.m, self.n = len(board), len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] in root:
                    self._dfs(board, i, j, "", root)

    def _dfs(self, board, x, y, s, root):
        s += board[x][y]
        root = root[board[x][y]]
        if self.end_of_word in root:
            self.ret.add(s)
        temp, board[x][y] = board[x][y], '@'
        for k in range(4):
            i, j = x + self.dx[k], y + self.dy[k]
            if 0 <= i < self.m and 0 <= j < self.n \
                    and board[i][j] != '@' \
                    and board[i][j] in root:
                self._dfs(board, i, j, s, root)
        board[x][y] = temp
