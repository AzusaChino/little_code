import collections
from typing import List


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        # edge case check
        if not grid or grid[0][0] == 1:
            return -1

        n = len(grid)
        if grid[n - 1][n - 1] == 1:
            return -1
        
        # eight directions
        dirs = [
            (1, 0),
            (0, 1),
            (-1, 0),
            (0, -1),
            (1, -1),
            (-1, 1),
            (1, 1),
            (-1, -1),
        ]

        q = collections.deque()
        q.append((0, 0))
        grid[0][0] = 1
        step = 0
        # bfs
        while q:
            step += 1
            size = len(q)
            for _ in range(size):
                x, y = q.popleft()
                if x == n - 1 and y == n - 1:
                    return step

                for dx, dy in dirs:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < n and 0 <= ny < n and grid[nx][ny] == 0:
                        q.append((nx, ny))
                        grid[nx][ny] = 1

        return -1
