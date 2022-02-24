from typing import List


class Solution:
    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if not matrix:
            return []
        self.directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        m = len(matrix)
        n = len(matrix[0])
        p_visited = [[False for _ in range(n)] for _ in range(m)]

        a_visited = [[False for _ in range(n)] for _ in range(m)]
        result = []

        for i in range(m):
            # p_visited[i][0] = True
            # a_visited[i][n-1] = True
            self.dfs(matrix, i, 0, p_visited, m, n)
            self.dfs(matrix, i, n - 1, a_visited, m, n)
        for j in range(n):
            # p_visited[0][j] = True
            # a_visited[m-1][j] = True
            self.dfs(matrix, 0, j, p_visited, m, n)
            self.dfs(matrix, m - 1, j, a_visited, m, n)

        for i in range(m):
            for j in range(n):
                if p_visited[i][j] and a_visited[i][j]:
                    result.append([i, j])
        return result

    def dfs(self, matrix, i, j, visited, m, n):
        # when dfs called, meaning its caller already verified this point
        visited[i][j] = True
        for dir in self.directions:
            x, y = i + dir[0], j + dir[1]
            if (
                x < 0
                or x >= m
                or y < 0
                or y >= n
                or visited[x][y]
                or matrix[x][y] < matrix[i][j]
            ):
                continue
            self.dfs(matrix, x, y, visited, m, n)


class Solution_:
    ret = []
    x = -1
    y = -1

    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        self.x = len(matrix[0])
        self.y = len(matrix)
        self._helper(matrix, 0, 0)
        return self.ret

    def _helper(self, matrix, a, b):
        if (a == self.x - 1 and b == self.y - 1) or a >= self.x or b >= self.y:
            return
        if self.checkPacific(matrix, a, b) and self.checkAtlantic(matrix, a, b):
            self.ret.append((a, b))
        self._helper(matrix, a + 1, b)
        self._helper(matrix, a, b + 1)

    def checkPacific(self, matrix, _x, _y) -> bool:
        if _x == 0 or _y == 0:
            return True
        val = matrix[_x][_y]
        for i in range(_x + 1):
            val -= matrix[i][_y]
        if val > 0:
            return True
        for i in range(_y + 1):
            val -= matrix[_x][i]
        if val > 0:
            return True
        return False

    def checkAtlantic(self, matrix, _x, _y) -> bool:
        if _x == self.x - 1 or _y == self.y - 1:
            return True
        val = matrix[_x][_y]
        for i in range(_x, self.x):
            val -= matrix[i][_y]
        if val > 0:
            return True
        val = matrix[_x][_y]
        for i in range(_y, self.y):
            val -= matrix[_x][i]
        if val > 0:
            return True
        return False