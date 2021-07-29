from typing import List


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        # BFS helper #
        def bfs(node):
            from collections import deque

            q = deque()
            i, j = node
            q.append(((i, j), 0))  # d (dist to a zero) = 0 initially
            visited = set()
            dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
            while q:
                for i in range(len(q)):
                    coor, d = q.popleft()
                    x, y = coor
                    # if a zero nei is found
                    if matrix[x][y] == 0:
                        return d
                    visited.add(coor)
                    # investiagte neighbours
                    for dir in dirs:
                        newX, newY = x + dir[0], y + dir[1]
                        # within bounds:
                        if (
                            newX >= 0
                            and newX <= len(matrix) - 1
                            and newY >= 0
                            and newY <= len(matrix[0]) - 1
                        ):
                            # not seen:
                            if (newX, newY) not in visited:
                                q.append(((newX, newY), d + 1))
            return -1

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 1:
                    d = bfs((i, j))  # d = closest dist to a 0
                    matrix[i][j] = d  # update M with d
        return matrix
