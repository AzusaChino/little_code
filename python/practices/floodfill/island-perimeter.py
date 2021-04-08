from typing import List


class Solution:
    def island_perimeter(self, grid: List[List[int]]) -> int:
        lands, neighbours = 0,0
        r, c = len(grid), len(grid[0])
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 1:
                    lands += 1
                    if i < r and grid[i+1][j] == 1:
                        neighbours += 1
                    if j < c and grid[i][j+1] == 1:
                        neighbours += 1
        return lands*4 - neighbours * 2

