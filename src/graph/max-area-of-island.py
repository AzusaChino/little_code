from typing import List


class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        def sink(grid, i, j) -> int:
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[i]):
                return 0
            if grid[i][j] == 0:
                return 0
            grid[i][j] = 0
            return (
                1
                + sink(grid, i - 1, j)
                + sink(grid, i + 1, j)
                + sink(grid, i, j - 1)
                + sink(grid, i, j + 1)
            )

        if not grid:
            return 0
        ret = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    island = sink(grid, i, j)
                    ret = max(island, ret)
        return ret


if __name__ == "__main__":
    s = Solution()
    grid = [
        [0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
        [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
        [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0],
    ]
    print(s.maxAreaOfIsland(grid))
