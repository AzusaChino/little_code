from typing import List


class Solution:
    def __init__(self):
        self.res = []

    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [["."] * n for _ in range(n)]
        self.backtrack(board, 0)
        return self.res

    def backtrack(self, board: List[List[str]], row: int) -> None:
        if row == len(board):
            self.res.append([row[:] for row in board])
            return

        n = len(board[row])
        for col in range(n):
            if not self.isValid(board, row, col):
                continue

            board[row][col] = "Q"
            self.backtrack(board, row + 1)
            board[row][col] = "."

    def isValid(self, board: List[List[str]], row: int, col: int) -> bool:
        n = len(board)
        # 检查列是否有皇后冲突
        for i in range(n):
            if board[i][col] == "Q":
                return False

        # 检查右上方是否有皇后冲突
        r, c = row - 1, col + 1
        while r >= 0 and c < n:
            if board[r][c] == "Q":
                return False
            r -= 1
            c += 1

        # 检查左上方是否有皇后冲突
        r, c = row - 1, col - 1
        while r >= 0 and c >= 0:
            if board[r][c] == "Q":
                return False
            r -= 1
            c -= 1

        return True
