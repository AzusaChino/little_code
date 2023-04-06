from typing import List


class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        def sink(grid, i, j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[i]):
                return
            # water
            if grid[i][j] == 1:
                return
            grid[i][j] = 1
            sink(grid, i - 1, j)
            sink(grid, i + 1, j)
            sink(grid, i, j - 1)
            sink(grid, i, j + 1)

        if not grid:
            return 0
        ret = 0
        # 1. sink those islands linked the corner, they are not closed islands
        for i in range(len(grid)):
            sink(grid, i, 0)
            sink(grid, i, len(grid[0]) - 1)
        for j in range(len(grid[0])):
            sink(grid, 0, j)
            sink(grid, len(grid) - 1, j)
        # 2. search and count closed islands
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    sink(grid, i, j)
                    ret += 1
        return ret


if __name__ == "__main__":
    s = Solution()
    grid = [
        [
            0,
            0,
            0,
            1,
            1,
            1,
            0,
            0,
            0,
            1,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            1,
            1,
            1,
            0,
            0,
            1,
            1,
            1,
            1,
            0,
            0,
            1,
            0,
        ],
        [
            1,
            1,
            0,
            1,
            1,
            1,
            0,
            1,
            1,
            1,
            1,
            1,
            0,
            1,
            0,
            1,
            0,
            1,
            1,
            0,
            1,
            0,
            1,
            1,
            1,
            1,
            0,
            0,
            1,
            0,
        ],
    ]
    print(s.closedIsland(grid))
