from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        def calc_adj(grid, i, j) -> int:
            adj = 0
            if i > 0 and grid[i - 1][j] == 1:
                adj += 1
            if i < len(grid) - 1 and grid[i + 1][j] == 1:
                adj += 1
            if j > 0 and grid[i][j - 1] == 1:
                adj += 1
            if j < len(grid[i]) - 1 and grid[i][j + 1] == 1:
                adj += 1
            return adj

        if not grid:
            return 0
        islands = 0
        adj = 0

        # count islands & adjacent times
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    islands += 1
                    adj += calc_adj(grid, i, j)
        return 4 * islands - adj


if __name__ == "__main__":
    s = Solution()
    grid = [[1]]
    print(s.islandPerimeter(grid))
