from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def sink(grid, i, j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[i]):
                return
            if grid[i][j] == "0":
                return

            grid[i][j] = "0"
            sink(grid, i - 1, j)
            sink(grid, i + 1, j)
            sink(grid, i, j - 1)
            sink(grid, i, j + 1)

        if not grid:
            return 0
        ret = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == "1":
                    sink(grid, i, j)
                    ret += 1
        return ret


if __name__ == "__main__":
    s = Solution()
    grid = [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"],
    ]
    print(s.numIslands(grid))
