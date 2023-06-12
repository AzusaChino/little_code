from typing import List


class UF:
    def __init__(self, n) -> None:
        self.n = n
        self.parent = list(range(n))
        self.rank = [1] * n

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, p, q):
        rootP, rootQ = self.find(p), self.find(q)
        if rootP == rootQ:
            return 0
        if self.rank[rootP] > self.rank[rootQ]:
            self.parent[rootQ] = rootP
            self.rank[rootP] += self.rank[rootQ]
        else:
            self.parent[rootP] = rootQ
            self.rank[rootQ] += self.rank[rootP]
        return 1

    def getTreeSize(self):
        sz = 0
        for i, v in enumerate(self.parent):
            if i == v:
                sz += 1
        return sz


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        m, n = len(grid), len(grid[0])
        uf = UF(m * n)
        dummy = (m * n) - 1

        def hepler(r, c, leader):
            m, n = len(grid), len(grid[0])
            if r < 0 or r >= m or c < 0 or c >= n or grid[r][c] == "0":
                return
            cur = i*m + j
            if uf.find(cur) == uf.find(leader):
                return
            uf.union(cur, leader)

            hepler(r - 1, c, leader)
            hepler(r + 1, c, leader)
            hepler(r, c - 1, leader)
            hepler(r, c + 1, leader)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "0":
                    uf.union(i * m + j, dummy)
                else:
                    hepler(i, j, i * m + j)

        return uf.getTreeSize() - 1


if __name__ == "__main__":
    s = Solution()
    grid = [
        ["1", "1", "0", "0", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "1", "0", "0"],
        ["0", "0", "0", "1", "1"],
    ]
    print(s.numIslands(grid))
