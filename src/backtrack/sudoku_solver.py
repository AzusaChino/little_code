from typing import List

L = 9


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        def backtrack(i, j) -> bool:
            if j == L:
                return backtrack(i + 1, 0)
            if i == L:
                return True
            if board[i][j] != ".":
                return backtrack(i, j + 1)
            for ch in range("1", "10"):
                if not isValid(i, j, ch):
                    continue
                board[i][j] = ch
                # fast return
                if backtrack(i, j + 1):
                    return True
                board[i][j] = "."
            return False

        def isValid(r, c, n):
            for i in range(L):
                if board[r][i] == n:
                    return False
                if board[i][c] == n:
                    return False
                if board[(r // 3) * 3 + i // 3][(c // 3) * 3 + i // 3] == n:
                    return False
            return True

        backtrack(0, 0)
        print(board)


if __name__ == "__main__":
    s = Solution()
