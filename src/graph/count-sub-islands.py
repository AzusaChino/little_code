from typing import List


class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        def sink(grid, i, j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[i]):
                return
            # water
            if grid[i][j] == 0:
                return
            grid[i][j] = 0
            sink(grid, i - 1, j)
            sink(grid, i + 1, j)
            sink(grid, i, j - 1)
            sink(grid, i, j + 1)

        # an island in grid2 and the relate i,j in grid1 is water, which indicates non sub-island
        for i in range(len(grid1)):
            for j in range(len(grid1[i])):
                if grid1[i][j] == 0 and grid2[i][j] == 1:
                    sink(grid2, i, j)

        # treat the rest as sub-islands
        ret = 0
        for i in range(len(grid2)):
            for j in range(len(grid2[i])):
                if grid2[i][j] == 1:
                    sink(grid2, i, j)
                    ret += 1
        return ret


if __name__ == "__main__":
    s = Solution()
    grid1 = [
        [1, 0, 1, 0, 1],
        [1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0],
        [1, 1, 1, 1, 1],
        [1, 0, 1, 0, 1],
    ]
    grid2 = [
        [0, 0, 0, 0, 0],
        [1, 1, 1, 1, 1],
        [0, 1, 0, 1, 0],
        [0, 1, 0, 1, 0],
        [1, 0, 0, 0, 1],
    ]
    print(s.countSubIslands(grid1, grid2))
