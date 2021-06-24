import numpy as np
from functools import reduce

class Solution(object):
    def findPaths(self, m, n, N, i, j):
        paths = np.zeros((m, n), dtype=object)
        paths[i][j] = 1
        out = 0
        for _ in range(N):
            prev = paths
            paths = prev * 0
            paths[1:] += prev[:-1]
            paths[:-1] += prev[1:]
            paths[:, 1:] += prev[:, :-1]
            paths[:, :-1] += prev[:, 1:]
            out += 4 * prev.sum() - paths.sum()
        return out % (10 ** 9 + 7)

    def findPaths(self, m, n, N, x, y):
        return reduce(lambda M, _:
              [[(i == 0 or M[i - 1][j]) + (i + 1 == m or M[i + 1][j])
              + (j == 0 or M[i][j - 1]) + (j + 1 == n or M[i][j + 1])
              for j in range(n)] for i in range(m)], range(N),
              [[0 for i in range(n)] for j in range(m)])[x][y] % (10 ** 9 + 7)
