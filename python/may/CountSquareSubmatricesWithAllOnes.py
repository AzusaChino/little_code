from typing import List


class Solution:
    def count(self, matrix: List[List[int]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        row, col = len(matrix), len(matrix[0])
        res = 0
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == 1:
                    if i == 0 or j == 0:
                        res += 1
                    else:
                        cell_val = min(matrix[i - 1][j - 1], matrix[i][j - 1], matrix[i - 1][j]) + matrix[i][j]
                        res += cell_val
                        matrix[i][j] = cell_val
        return res
