from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return False
        M, N = len(board), len(board[0])

        def dfs(i, j, word):
            if len(word) == 0:
                return True
            if i < 0 or i >= M or j < 0 or j >= N or word[0] != board[i][j]:
                return False
            tmp = board[i][j]
            # visited
            board[i][j] = "#"
            word = word[1:]
            res = (
                dfs(i + 1, j, word)
                or dfs(i - 1, j, word)
                or dfs(i, j + 1, word)
                or dfs(i, j - 1, word)
            )

            board[i][j] = tmp
            return res

        for i in range(M):
            for j in range(N):
                if dfs(i, j, word):
                    return True
        return False
