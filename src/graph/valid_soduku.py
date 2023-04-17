from typing import List


def is_valid(board: List[List[int]]) -> bool:
    seen = set()
    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] != ".":
                if (
                    "%d(%s)" % (i, board[i][j]) in seen
                    or "(%s)%d in col" % (board[i][j], j) in seen
                    or "%d(%s)%d in block" % (i // 3, board[i][j], j // 3) in seen
                ):
                    return False
                seen.add("%d(%s)" % (i, board[i][j]))
                seen.add("(%s)%d in col" % (board[i][j], j))
                seen.add("%d(%s)%d in block" % (i // 3, board[i][j], j // 3))
    return True


if __name__ == "__main__":
    board = [
        ["5", "3", ".", ".", "7", ".", ".", ".", "."],
        ["6", ".", ".", "1", "9", "5", ".", ".", "."],
        [".", "9", "8", ".", ".", ".", ".", "6", "."],
        ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
        ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
        ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
        [".", "6", ".", ".", ".", ".", "2", "8", "."],
        [".", ".", ".", "4", "1", "9", ".", ".", "5"],
        [".", ".", ".", ".", "8", ".", ".", "7", "9"],
    ]
    print(is_valid(board))
